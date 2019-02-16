package org.mql.metier;

import javax.transaction.Transactional;

import org.mql.dao.RoleRepository;
import org.mql.dao.UserRepository;
import org.mql.entities.Role;
import org.mql.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountMetierImpl implements IAccountMetier {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User saveUser(User user) {
		String hashPwd = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPwd);
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public User findUserByUsername(String userName) {
		User user = userRepository.findByUsername(userName);
		return user;
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		boolean exist = true;
		Role role = roleRepository.findByRoleName(roleName);
		System.out.println(role.toString());
		User userApp = userRepository.findByUsername(userName);
		System.out.println(userApp.toString());
		System.out.println("*****************************************");
		System.out.println(role.toString());
		System.out.println(userApp.toString());
//		if (!(userApp.getRole() == null)) {
			userApp.setRole(role);
//			exist = false;
//		}
		userRepository.save(userApp);
//		return exist;
	}

}
