package org.mql.dao;

import java.util.List;

import org.mql.entities.Article;
import org.mql.entities.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PresentationRepository extends JpaRepository<Presentation, Long> {
	@Query("Select article  From Presentation  ")
	public List<Article> FindAllArticleAffected();

}
