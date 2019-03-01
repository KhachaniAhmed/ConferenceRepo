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
		List<Article> articles = new ArrayList<Article>();
		this.articleRepository.findAll().forEach(r -> {
			List<View> views = new ArrayList<View>();
			r.getViews().forEach(v -> {
				if (v.getView().equals("accepted"))
					views.add(v);
			});
			if (views.size() >= 2)
				articles.add(r);
		});
		return articles;
	}

}
