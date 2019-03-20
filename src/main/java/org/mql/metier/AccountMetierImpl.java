package org.mql.metier;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.mql.dao.RoleRepository;
import org.mql.dao.UserRepository;
import org.mql.entities.Role;
import org.mql.entities.User;
import org.mql.security.JwtTokenUtil;
import org.mql.security.SecurityConstants;
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
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

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
	public Role findRoleByRolename(String rolename) {
		Role role= roleRepository.findByRoleName(rolename);
		return role;
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		boolean exist = true;
		Role role = roleRepository.findByRoleName(roleName);
		User userApp = userRepository.findByUsername(userName);
//		if (!(userApp.getRole() == null)) {
		userApp.setRole(role);
//			exist = false;
//		}
		userRepository.save(userApp);
//		return exist;
	}
	@Override
	public User getCurrentUser(HttpServletRequest request) {
		String jwtToken = request.getHeader(SecurityConstants.HEADER_STRING);
		User user = userRepository.findByUsername(jwtTokenUtil.getUsernameFromToken(jwtToken));
		if (user == null) {
			throw new RuntimeException("No Authenticated User Found !");
		}
		return user;
	}

}
