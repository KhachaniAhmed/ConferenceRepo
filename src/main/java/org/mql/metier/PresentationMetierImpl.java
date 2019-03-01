package org.mql.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.mql.dao.PresentationRepository;
import org.mql.entities.Presentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PresentationMetierImpl implements IPresentationMetier {
	@Autowired
	private PresentationRepository presentationRepository;

	@Override
	public List<Presentation> getAll() {
		return presentationRepository.findAll();
	}

	@Override
	public Presentation getOne(Long id) {
		// TODO Auto-generated method stub
		return presentationRepository.getOne(id);
	}

	@Override
	public Presentation save(Presentation presentation) {
		// TODO Auto-generated method stub
		return presentationRepository.save(presentation);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		presentationRepository.deleteById(id);
	}

}
