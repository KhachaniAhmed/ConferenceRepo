package org.mql.metier;

import java.util.List;

import org.mql.entities.Chair;
import org.mql.entities.Reviewer;
import org.mql.entities.View;

public interface IReviewerMetier {
	
	Reviewer findByUsername(String username);
	Reviewer save(Reviewer reviewer);
	List<Reviewer> getAll();
	Reviewer getOne(Long id);
	void deleteByID(Long id);
}
