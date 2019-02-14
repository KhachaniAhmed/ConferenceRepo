package org.mql.services;

import java.util.List;

import org.mql.dao.FileRepository;
import org.mql.entities.Article;
import org.mql.entities.UploadFileResponse;
import org.mql.metier.IArticleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController(value="articles")
public class ArticleService {
	
	@Autowired
	private IArticleMetier articleMetier;
	@Autowired
	private FileRepository fileRepository;
	
	@GetMapping
	public List<Article> getAllByDomainId(@RequestParam Long id){
		return articleMetier.getAllByDomainId(id);
	}
	@GetMapping(value = "/{id}")
	public Article getOne(@PathVariable Long id) {
		return articleMetier.getOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		articleMetier.deleteById(id);
	}
	
	@GetMapping(value = "/{id}/files")
	public List<UploadFileResponse> getFiles(@PathVariable Long id) {
		return fileRepository.findByArticleId(id);
	}

	@PostMapping
	public Article create(@RequestBody Article article) {
		return articleMetier.save(article);
	}

	@PutMapping
	public Article update(@RequestBody Article article) {
		return articleMetier.save(article);
	}

}
