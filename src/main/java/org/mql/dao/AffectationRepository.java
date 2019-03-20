package org.mql.dao;

import java.util.List;

import org.mql.entities.Affectation;
import org.mql.entities.Presentation;
import org.mql.entities.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AffectationRepository extends JpaRepository<Affectation, Long> {
	@Query("Select presentation  From Affectation  ")
	public List<Presentation> FindAllPreseanttionAffected();
	List<Affectation> findByPresentationId(Long presentationId);

}
