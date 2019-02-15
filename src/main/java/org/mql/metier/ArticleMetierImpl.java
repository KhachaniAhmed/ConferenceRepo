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
	public List<Article> getAllByDomainId(Long id) {
		return articleRepository.findByDomainId(id);
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

}
