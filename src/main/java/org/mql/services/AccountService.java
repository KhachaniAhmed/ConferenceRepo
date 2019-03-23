package org.mql.services;

import javax.servlet.http.HttpServletRequest;

import org.mql.entities.Author;
import org.mql.entities.User;
import org.mql.metier.IAccountMetier;
import org.mql.property.RegisterForm;
import org.mql.security.JwtTokenUtil;
import org.mql.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AccountService {
	@Autowired
	private IAccountMetier iAccountMetie;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping("/register")
	public User register(@RequestBody RegisterForm userForm) {
		System.out.println(userForm.toString());
		Author appuser = new Author();
		if (!(userForm.getPassword().equals(userForm.getRepassword())))
			throw new RuntimeException("you must confirmm your password");
		Author user = iAccountMetie.findAuthorByUsername(userForm.getUsername());
		if (user != null)
			throw new RuntimeException("this user already exist ");
		appuser.setUsername(userForm.getUsername());
		appuser.setPassword(userForm.getPassword());
		appuser.setRole(iAccountMetie.findRoleByRolename("AUTHOR"));
		iAccountMetie.saveUser(appuser);
		return appuser;
	}

	@RequestMapping(value = "/currentUser")
	public User currentUser(HttpServletRequest request) {
		String jwtToken = request.getHeader(SecurityConstants.HEADER_STRING);
		User user = iAccountMetie.findUserByUsername(jwtTokenUtil.getUsernameFromToken(jwtToken));
		return user;
	}

}
