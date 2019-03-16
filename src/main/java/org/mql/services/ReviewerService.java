package org.mql.services;

import java.util.List;

import org.mql.dao.ReviewerRepository;
import org.mql.entities.Article;
import org.mql.entities.Chair;
import org.mql.entities.View;
import org.mql.metier.IReviewerMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewerService {
	
	@Autowired
	private IReviewerMetier reviewerMetier;
	@Autowired
	private ReviewerRepository ReviewerRepository;
	
	@GetMapping(value = "reviews/{articleId}")
	public List<View> getAll(@PathVariable Long articleId) {
		return reviewerMetier.getAllByArticleId(articleId);
	}
	


	
}
