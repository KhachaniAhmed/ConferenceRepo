package org.mql.metier;

import java.util.List;

import org.mql.entities.Article;

public interface IArticleMetier {

	List<Article> getAllByDomaineId(Long id);

	void deleteById(Long id);

	Article getOne(Long id);

	Article save(Article article);

	void reviewArticle(Article article);

	List<Article> getAll();

}
