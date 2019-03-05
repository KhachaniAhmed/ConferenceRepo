package org.mql.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.mql.dao.AffectationRepository;
import org.mql.entities.Affectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AffectationMetierImpl implements IAffectationMetier {
	@Autowired
	private AffectationRepository affectationRepository;

	@Override
	public List<Affectation> getAll() {
		// TODO Auto-generated method stub
		return affectationRepository.findAll();
	}

	@Override
	public Affectation save(Affectation affectation) {
		// TODO Auto-generated method stub
		return affectationRepository.save(affectation);
	}

	@Override
	public Affectation getOne(Long id) {
		// TODO Auto-generated method stub
		return affectationRepository.getOne(id);
	}

	@Override
	public void deleteByID(Long id) {
		// TODO Auto-generated method stub
		affectationRepository.deleteById(id);
	}

}
