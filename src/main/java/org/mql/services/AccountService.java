package org.mql.services;

import org.mql.entities.User;
import org.mql.metier.IAccountMetier;
import org.mql.property.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AccountService {
	@Autowired
	private IAccountMetier iAccountMetie;

	@PostMapping("/register")
	public User register(@RequestBody RegisterForm userForm) {
		System.out.println(userForm.toString());
		User appuser = new User();
		if (!(userForm.getPassword().equals(userForm.getRepassword())))
			throw new RuntimeException("you must confirmm your password");
		User user = iAccountMetie.findUserByUsername(userForm.getUsername());
		if (user != null)
			throw new RuntimeException("this user already exist ");
		appuser.setUsername(userForm.getUsername());
		appuser.setPassword(userForm.getPassword());
		appuser.setRole(iAccountMetie.findRoleByRolename("USER"));
		iAccountMetie.saveUser(appuser);
		return appuser;
	}

}
