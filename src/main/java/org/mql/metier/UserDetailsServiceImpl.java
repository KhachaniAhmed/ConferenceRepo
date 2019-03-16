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
		System.out.println("****************!!!" + username);
		org.mql.entities.User user = iAccountMetier.findUserByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
//		System.out.println(user.toString());
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		System.out
				.println("l'utilisateur qui on a recuperer a partie du font end ***************" + user.getUsername());
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
}