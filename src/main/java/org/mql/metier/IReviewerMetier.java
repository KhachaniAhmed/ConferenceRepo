package org.mql.metier;

import java.util.List;

import org.mql.entities.View;

public interface IReviewerMetier {
	
	void reviewArticle(Long reviewerId, Long articleId);
	
	List<View> getAllByArticleId(Long articleId);

}
