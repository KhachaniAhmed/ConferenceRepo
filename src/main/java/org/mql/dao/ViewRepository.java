package org.mql.dao;

import java.util.List;

import org.mql.entities.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ViewRepository extends JpaRepository<View, Long> {

	@Query("Select v from View v Where v.view='accepted'")
	public List<View> findAllViewsAccepted();
	
	List<View> findByArticleId(Long articleId);

	List<View> findByArticleIdAndRateGreaterThan(Long articleId, int rate);


}
