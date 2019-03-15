package org.mql.dao;

import java.util.List;

import org.mql.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	List<Article> findByStatusLike(String status);

	List<Article> findByPresentationIdAndStatusLike(Long presentationId, String status);
}
