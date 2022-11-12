package com.example.SpringBootApplication.SpringBootStudent.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SpringBootApplication.SpringBootStudent.Config.UserDetailsImpl;
import com.example.SpringBootApplication.SpringBootStudent.Entity.User;
import com.example.SpringBootApplication.SpringBootStudent.Repository.UserRepository;


public class UserServiceImpl implements UserDetailsService {

	/**
	 * Hear we will be taking The new User :-
	 */
	@Autowired
	private  UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// Creting The object of The user Class :-
		User user = userRepository.findByUserName(username);

		if (user == null) {

			throw new UsernameNotFoundException("user Not Found");
		}
		/*
		 * Passsing The value into The userDetailsImpl class beacause If We will be get
		 * The user :-
		 */
		return new UserDetailsImpl(user);
	}

}
