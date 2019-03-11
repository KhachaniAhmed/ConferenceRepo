package org.mql.metier;

import java.util.List;

import org.mql.entities.Jury;

public interface IJuryMetier {	
	List<Jury> getAll();
	Jury getOne(Long id);
	Jury save(Jury jury);
	void deleteById(Long id);

}
