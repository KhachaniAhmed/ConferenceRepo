package org.mql.services;

import org.mql.dao.ArticleRepository;
import org.mql.dao.FileRepository;
import org.mql.entities.Article;
import org.mql.entities.UploadFileResponse;
import org.mql.metier.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class FileService {

	private static final Logger logger = LoggerFactory.getLogger(FileService.class);

	@Autowired
	private FileStorageService fileStorageService;
	@Autowired
	private FileRepository fileRepository;
	@Autowired
	private ArticleRepository articleRepository;

	@PostMapping("/{id}/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
		Article article = articleRepository.getOne(id);

		String fileName = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();
		if (article != null) {
			UploadFileResponse uploadFileResponse = fileRepository.save(new UploadFileResponse(null, fileName,
					fileDownloadUri, file.getContentType(), file.getSize(), article));
			return uploadFileResponse;
		}
		return null;
	}

	@PostMapping("{id}/uploadMultipleFiles")
	public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
			@PathVariable Long id) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file, id)).collect(Collectors.toList());
	}

	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = fileStorageService.loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

}