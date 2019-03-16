package org.mql.metier;

import java.util.List;

import org.mql.dao.ReviewerRepository;
import org.mql.dao.ViewRepository;
import org.mql.entities.Reviewer;
import org.mql.entities.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewerMetier implements IReviewerMetier {

	@Autowired
	ReviewerRepository reviewerRepository;
	@Override
	public Reviewer findByUsername(String username) {
		return reviewerRepository.findByUsername(username);
	}


}
