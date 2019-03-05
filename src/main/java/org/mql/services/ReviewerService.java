package org.mql.services;

import org.mql.metier.IReviewerMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewerService {
	
	@Autowired
	private IReviewerMetier reviewerMetier;
	
}
