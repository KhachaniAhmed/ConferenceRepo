package org.mql.dao;

import org.mql.entities.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewerRepository extends JpaRepository<Reviewer,Long> {
	
	Reviewer findByUsername(String username);

}
