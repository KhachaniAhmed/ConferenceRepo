package org.mql.metier;

import java.util.List;

import org.mql.dao.ViewRepository;
import org.mql.entities.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewerMetier implements IReviewerMetier {

	@Autowired
	ViewRepository viewRepository;
	
	@Override
	public void reviewArticle(Long reviewerId, Long articleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<View> getAllByArticleId(Long articleId) {
		return viewRepository.findByArticleId(articleId);
	}

}
