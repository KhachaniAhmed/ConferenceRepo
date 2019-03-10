package org.mql.dao;

import org.mql.entities.Conference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ConferenceRepository extends JpaRepository<Conference,Long> {
	

	@Query("select c from Conference c where c.nom like :x")
	 Page<Conference> chercher(@Param("x")String mc,Pageable pageable);

}
