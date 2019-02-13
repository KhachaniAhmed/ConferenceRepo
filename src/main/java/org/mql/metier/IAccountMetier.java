package org.mql.metier;

import org.mql.entities.Role;
import org.mql.entities.User;

public interface IAccountMetier {
	public User saveUser(User user);
	public Role saveRole(Role role);
	public User findUserByUsername(String userName);
	public boolean addRoleToUser(String userName, String role);
}
