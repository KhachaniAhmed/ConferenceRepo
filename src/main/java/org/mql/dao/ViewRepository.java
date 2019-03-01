package org.mql.dao;

import java.util.List;

import org.mql.entities.Article;
import org.mql.entities.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ViewRepository extends JpaRepository<View, Long> {
//  @Query("Select Article from View")	
//  public List<Article> findAllArticle();
  
}
