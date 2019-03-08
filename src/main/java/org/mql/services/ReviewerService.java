package org.mql.services;

import java.util.List;

import org.mql.entities.Article;
import org.mql.entities.Reviewer;
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
	
	@GetMapping(value = "reviews/{articleId}")
	public List<View> getAll(@PathVariable Long articleId) {
		return reviewerMetier.getAllByArticleId(articleId);
	}
	
	@PostMapping(value = "reviews")
	public View create(@RequestBody View view) {
		Reviewer reviewer =new Reviewer();
		reviewer.setId(4L);
		view.setReviewer(reviewer);
		return reviewerMetier.save(view);
	}

	
}
