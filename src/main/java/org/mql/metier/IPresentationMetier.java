package org.mql.metier;

import java.util.List;

import org.mql.entities.Presentation;

public interface IPresentationMetier {
	List<Presentation> getAll();
	Presentation getOne(Long id);
	Presentation save(Presentation presentation);
	void deleteById(Long id);

}
