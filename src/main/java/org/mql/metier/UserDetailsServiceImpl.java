package org.mql.metier;

import java.util.ArrayList;
import java.util.Collection;

import org.mql.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IAccountMetier iAccountMetier;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		org.mql.entities.User user = iAccountMetier.findUserByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
}