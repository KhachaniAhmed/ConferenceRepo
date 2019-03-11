package org.mql.dao;

import org.mql.entities.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PresentationRepository extends JpaRepository<Presentation, Long> {
	
}
