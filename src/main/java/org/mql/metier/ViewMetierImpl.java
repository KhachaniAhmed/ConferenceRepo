package org.mql.metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.mql.dao.ViewRepository;
import org.mql.entities.Article;
import org.mql.entities.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ViewMetierImpl implements IViewMetier {
	@Autowired
	private ViewRepository viewRepository;


	@Override
	public List<View> getAllByArticleId(Long articleId) {
		return viewRepository.findByArticleId(articleId);
	}

	@Override
	public View save(View view) {
		return viewRepository.save(view);
	}

	@Override
	public List<View> findByArticleIdAndRateGreaterThan(Article article, int rate) {
		return viewRepository.findByArticleIdAndRateGreaterThan(article.getId(),rate);
	}


	@Override
	public List<View> getViewsAccepted() {
		return viewRepository.findAllViewsAccepted();
	}

}
