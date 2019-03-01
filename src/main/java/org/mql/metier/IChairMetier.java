package org.mql.metier;

import java.util.List;

import org.mql.entities.Chair;

public interface IChairMetier {
	Chair save(Chair chair);
	List<Chair> getAll();
	Chair getOne(Long id);
	void deleteByID(Long id);

}
