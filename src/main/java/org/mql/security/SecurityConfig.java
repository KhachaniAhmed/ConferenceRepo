package org.mql.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@CrossOrigin(origins = "http://localhost:4200")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	//	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	//	.and()
	//		.authorizeRequests()
//			.antMatchers("/login/**", "/Client/register", "/Admin/getOrganisms", "/Admin/getSousCategories").permitAll()
//			.antMatchers("/Admin/**").hasAuthority("ROLE_ADMIN")
//			.antMatchers("/conferences/**").permitAll()
//			.antMatchers("/article/**").permitAll()
//			.antMatchers("/login/**").permitAll()
//			.antMatchers("/register/**").permitAll()

//			.anyRequest().authenticated()
//		.and()
//			.addFilter(new JWTAuthenticationFilter(authenticationManager()))
//			.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/register/**").permitAll().antMatchers("/login/**").permitAll().antMatchers("/h2-console/**").permitAll()
				.antMatchers("/conferences/**").hasAuthority("ADMIN").antMatchers("/articles/**").hasAuthority("ADMIN")
				.antMatchers("/presentations/**").hasAuthority("ADMIN")
				.antMatchers("/chairs/**").hasAuthority("ADMIN")
				.antMatchers("/home/**").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
