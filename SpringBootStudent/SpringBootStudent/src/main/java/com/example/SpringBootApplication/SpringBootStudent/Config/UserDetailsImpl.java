package com.example.SpringBootApplication.SpringBootStudent.Config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.SpringBootApplication.SpringBootStudent.Entity.Role;
import com.example.SpringBootApplication.SpringBootStudent.Entity.User;

public class UserDetailsImpl implements UserDetails {

	/**
	 * Spring security will Only Eble to find This Class :- Hear we will be granting
	 * all The Authantication releted data for The users :-
	 */

	/**
	 * taking The refarence Veriebel for The user :-
	 */
	private User user;

	/**
	 * Creting The constractor and Set The user first which is Being passed From The
	 * userDetailsService class:-
	 */

	public UserDetailsImpl(User user) {
		this.user = user;
	}

	/**
	 * Hear we will be providing The authentication to The user :-
	 */

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		/*
		 * Now granting The roles To the user :-
		 */

		// taking how Many roles that the user got :-

		List<Role> roles = user.getListRole();
		List<SimpleGrantedAuthority> auth = new ArrayList<>();
		for (Role role : roles)
			auth.add(new SimpleGrantedAuthority(role.getRoleName()));
		return auth;

	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
