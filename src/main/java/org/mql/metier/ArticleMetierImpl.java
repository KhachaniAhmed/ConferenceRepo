package org.mql.metier;

import java.util.List;
import javax.transaction.Transactional;
import org.mql.dao.ArticleRepository;
import org.mql.entities.Article;
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

}
