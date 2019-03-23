package org.mql.metier;

import java.util.List;

import org.mql.entities.Affectation;
import org.mql.entities.Presentation;

public interface IAffectationMetier {
	List<Affectation> findByPresentation(Long presentationId);
	List<Affectation> getAll();
	Affectation save(Affectation affectation);
	Affectation getOne(Long id);
	void deleteByID(Long id);
	List<Presentation> getAllPreseantionAfffected();
	

}
