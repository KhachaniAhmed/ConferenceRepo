package org.mql.metier;

import java.util.List;

import org.mql.dao.ReviewerRepository;
import org.mql.dao.ViewRepository;
import org.mql.entities.Reviewer;
import org.mql.entities.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ReviewerMetier implements IReviewerMetier {

	@Autowired
	ReviewerRepository reviewerRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Reviewer findByUsername(String username) {
		return reviewerRepository.findByUsername(username);
	}
	@Override
	public Reviewer save(Reviewer reviewer) {
		String hashPwd = bCryptPasswordEncoder.encode(reviewer.getPassword());
		reviewer.setPassword(hashPwd);
		return reviewerRepository.save(reviewer);
	}
	@Override
	public List<Reviewer> getAll() {
		// TODO Auto-generated method stub
		return reviewerRepository.findAll();
	}
	@Override
	public Reviewer getOne(Long id) {
		// TODO Auto-generated method stub
		return reviewerRepository.getOne(id);
	}
	@Override
	public void deleteByID(Long id) {
		reviewerRepository.deleteById(id);
		
	}


}
