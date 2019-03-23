package org.mql.metier;

import javax.servlet.http.HttpServletRequest;

import org.mql.entities.Author;
import org.mql.entities.Role;
import org.mql.entities.User;

public interface IAccountMetier {
	public Author saveUser(Author user);
	public Role saveRole(Role role);
	public Author findAuthorByUsername(String userName);
	public User findUserByUsername(String userName);
	public Role findRoleByRolename(String rolename);
	public void addRoleToUser(String userName, String role);
	User getCurrentUser(HttpServletRequest request);
}
