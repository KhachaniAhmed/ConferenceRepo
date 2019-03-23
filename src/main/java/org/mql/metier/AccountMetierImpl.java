package org.mql.metier;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.mql.dao.AuthorRepository;
import org.mql.dao.RoleRepository;
import org.mql.dao.UserRepository;
import org.mql.entities.Author;
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
	private AuthorRepository authorRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public Author saveUser(Author author) {
		String hashPwd = bCryptPasswordEncoder.encode(author.getPassword());
		author.setPassword(hashPwd);
		return authorRepository.save(author);
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
		Author author = authorRepository.findByUsername(userName);
//		if (!(userApp.getRole() == null)) {
		author.setRole(role);
//			exist = false;
//		}
		authorRepository.save(author);
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

	@Override
	public Author findAuthorByUsername(String userName) {
		Author author = authorRepository.findByUsername(userName);
		return author;
	}

}
