package org.mql.metier;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mql.entities.Article;

public interface IArticleMetier {

	List<Article> getAll();

	List<Article> getAllByUsername(HttpServletRequest request);

	void deleteById(Long id);

	Article getOne(Long id);

	Article save(HttpServletRequest request, Article article);
	
	Article update(Article article);

	void reviewArticle(Article article);

	List<Article> articleAccepted();

	List<Article> getAllAccepted();

	List<Article> getAllRejected();
	

}
