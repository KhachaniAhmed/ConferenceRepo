package org.mql.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.mql.dao.ChairRepository;
import org.mql.entities.Chair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ChairMetierImpl implements IChairMetier {
	@Autowired
	private ChairRepository chairRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	public Chair save(Chair chair) {
		String hashPwd = bCryptPasswordEncoder.encode(chair.getPassword());
		chair.setPassword(hashPwd);
		return chairRepository.save(chair);
	}

	@Override
	public List<Chair> getAll() {
		// TODO Auto-generated method stub
		return chairRepository.findAll();
	}

	@Override
	public Chair getOne(Long id) {
		// TODO Auto-generated method stub
		return chairRepository.getOne(id);
	}

	@Override
	public void deleteByID(Long id) {
		chairRepository.deleteById(id);
	}

}
