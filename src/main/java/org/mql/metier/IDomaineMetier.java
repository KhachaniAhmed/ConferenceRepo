package org.mql.metier;

import java.util.List;

import org.mql.entities.Domaine;

public interface IDomaineMetier {
	List<Domaine> getAll();
	Domaine create(Domaine domaine);

}
