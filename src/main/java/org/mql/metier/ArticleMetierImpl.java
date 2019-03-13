package org.mql.metier;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.mql.dao.ArticleRepository;
import org.mql.entities.Article;
import org.mql.entities.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ArticleMetierImpl implements IArticleMetier {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private IViewMetier viewMetier;
	@Autowired
	private IPresentationMetier iPresentationMetier; 

	@Override
	public List<Article> getAllByDomaineId(Long id) {
		return articleRepository.findByDomaineId(id);
	}

	@Override
	public void deleteById(Long id) {
		articleRepository.deleteById(id);
	}

	@Override
	public Article getOne(Long id) {
		return articleRepository.getOne(id);
	}

	@Override
	public Article save(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public void reviewArticle(Article article) {
		articleRepository.save(article);
	}

	@Override
	public List<Article> getAll() {
		return articleRepository.findAll();
	}

	@Override
	public List<Article> articleAccepted() {
		List<Article> articlesAccepted = new ArrayList<Article>();
		List<View> views = viewMetier.getViewsAccepted();
		for (int i = 0; i < views.size() - 1; i++) {
			//if (views.get(i).getArticle().equals(views.get(i + 1).getArticle())) {
				if (!articlesAccepted.contains(views.get(i).getArticle()) && !iPresentationMetier.getAllArticleAffected().contains(views.get(i).getArticle()))
					articlesAccepted.add(views.get(i).getArticle());
			//}
		}
		return articlesAccepted;
	}
}
