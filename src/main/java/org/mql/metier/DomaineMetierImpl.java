package org.mql.metier;

import java.util.List;

import org.mql.dao.DomaineRepository;
import org.mql.entities.Domaine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomaineMetierImpl implements IDomaineMetier {

	@Autowired
	private DomaineRepository domaineRepository;

	@Override
	public List<Domaine> getAll() {
		return domaineRepository.findAll();
	}

	@Override
	public Domaine create(Domaine domaine) {
		// TODO Auto-generated method stub
		return domaineRepository.save(domaine);
	}

}
