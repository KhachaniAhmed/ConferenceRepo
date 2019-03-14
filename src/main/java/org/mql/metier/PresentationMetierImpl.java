package org.mql.metier;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.mql.dao.PresentationRepository;
import org.mql.entities.Article;
import org.mql.entities.Presentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PresentationMetierImpl implements IPresentationMetier {
	@Autowired
	private PresentationRepository presentationRepository;
	@Autowired
	private IAffectationMetier iAffectationMetier; 

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

	@Override
	public List<Presentation> getAllPresentationNotAffected() {
		List<Presentation> presentations = new ArrayList<Presentation>();
		getAll().forEach(presentation->{
			if(!iAffectationMetier.getAllPreseantionAfffected().contains(presentation))
				presentations.add(presentation);
		});
		return presentations;
	}

	@Override
	public List<Article> getAllArticleAffected() {
		List<Article> articles = new ArrayList<Article>();
		presentationRepository.FindAllArticleAffected().forEach(article->{
			if(!articles.contains(article))
				articles.add(article);
		});
		return articles;
	}

}
