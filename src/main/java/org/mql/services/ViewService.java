package org.mql.services;

import java.util.List;

import org.mql.entities.Reviewer;
import org.mql.entities.View;
import org.mql.metier.IReviewerMetier;
import org.mql.metier.IViewMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewService {
	@Autowired
	IViewMetier viewMetier;
	@Autowired
	private IReviewerMetier reviewerMetier;

	@GetMapping(value = "reviews/{articleId}")
	public List<View> getAll(@PathVariable Long articleId) {
		return viewMetier.getAllByArticleId(articleId);
	}

	@PostMapping(value = "reviews")
	public View create(@RequestBody View view) {
		Reviewer reviewer = reviewerMetier.findByUsername(view.getReviewer().getUsername());
		if (reviewer == null) {
			throw new RuntimeException("Reviwer does not exist");
		}
		view.setReviewer(reviewer);
		return viewMetier.save(view);
	}

}
