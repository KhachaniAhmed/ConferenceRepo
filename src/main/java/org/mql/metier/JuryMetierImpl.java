package org.mql.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.mql.dao.JuryRepository;
import org.mql.entities.Jury;
import org.mql.entities.Presentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JuryMetierImpl implements IJuryMetier {
	@Autowired
	private JuryRepository juryRepository;

	@Override
	public List<Jury> getAll() {
		return juryRepository.findAll();
	}

	@Override
	public Jury getOne(Long id) {
		return juryRepository.getOne(id);
	}

	@Override
	public Jury save(Jury jury) {
		return juryRepository.save(jury);
	}

	@Override
	public void deleteById(Long id) {
		juryRepository.deleteById(id);
	}

}
