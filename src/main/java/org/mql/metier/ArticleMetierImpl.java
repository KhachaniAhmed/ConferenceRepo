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

	public static final String ACCEPTED = "ACCEPTED";
	public static final String REJECTED = "REJECTED";
	public static final String IN_IVALUATION = "IN_IVALUATION";
	@Autowired
	private ArticleRepository articleRepository;
	public List<Article> getAll() {
		return articleRepository.findAll();
	}
	@Override
	public List<Article> getAllAccepted() {
		return articleRepository.findByStatusLike(ACCEPTED);
	}
	@Override
	public List<Article> getAllRejected() {
		return articleRepository.findByStatusLike(REJECTED);
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
	public List<Article> articleAccepted() {
//		List<Article> articlesAccepted = new ArrayList<Article>();
//		List<View> views = viewMetier.getViewsAccepted();
//		for (int i = 0; i < views.size() - 1; i++) {
//			//if (views.get(i).getArticle().equals(views.get(i + 1).getArticle())) {
//				if (!articlesAccepted.contains(views.get(i).getArticle()) && !iPresentationMetier.getAllArticleAffected().contains(views.get(i).getArticle()))
//					articlesAccepted.add(views.get(i).getArticle());
//			//}
//		}
//		return articlesAccepted;
		return articleRepository.findByPresentationIdAndStatusLike(null, ACCEPTED);
	}
}
