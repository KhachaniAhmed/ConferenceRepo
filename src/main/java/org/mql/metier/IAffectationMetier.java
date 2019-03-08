package org.mql.metier;

import java.util.List;

import org.mql.entities.Affectation;

public interface IAffectationMetier {
	List<Affectation> getAll();
	Affectation save(Affectation affectation);
	Affectation getOne(Long id);
	void deleteByID(Long id);
	

}
