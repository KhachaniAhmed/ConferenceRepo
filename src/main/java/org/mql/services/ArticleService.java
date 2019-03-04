 package org.mql.services;

import java.util.List;
import org.mql.dao.FileRepository;
import org.mql.entities.Article;
import org.mql.entities.UploadFileResponse;
import org.mql.metier.IArticleMetier;
import org.mql.metier.IViewMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ArticleService {

	@Autowired
	private IArticleMetier articleMetier;
	@Autowired
	private FileRepository fileRepository;

	@GetMapping(value = "articles")
	public List<Article> getAll() {
		System.err.println("debujxhvjeuydguing");
		return articleMetier.getAll();
	}

	@GetMapping(value = "articles/accepted")
	public List<Article> getAllAcepted() {
		return articleMetier.articleAccepted();
	}

	@GetMapping(value = "articles/domain/{id}")
	public List<Article> getAllByDomaineId(@RequestParam Long id) {
		return articleMetier.getAllByDomaineId(id);
	}

	@GetMapping(value = "articles/{id}")
	public Article getOne(@PathVariable Long id) {
		return articleMetier.getOne(id);
	}

	@DeleteMapping(value = "articles/{id}")
	public void delete(@PathVariable Long id) {
		articleMetier.deleteById(id);
	}

	@GetMapping(value = "articles/{id}/files")
	public List<UploadFileResponse> getFiles(@PathVariable Long id) {
		return fileRepository.findByArticleId(id);
	}

	@PostMapping
	public Article create(@RequestBody Article article) {
		System.out.println(article);
		return articleMetier.save(article);
	}

	@PutMapping(value = "articles")
	public Article update(@RequestBody Article article) {
		return articleMetier.save(article);
	}

	@PutMapping("/review")
	public void reviewArticle(@RequestParam Long id, @RequestAttribute String review) {
		Article article = articleMetier.getOne(id);
		// article.setReview(review);
		articleMetier.reviewArticle(article);
	}

}
