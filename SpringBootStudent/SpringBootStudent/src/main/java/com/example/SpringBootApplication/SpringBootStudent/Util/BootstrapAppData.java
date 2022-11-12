package com.example.SpringBootApplication.SpringBootStudent.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.SpringBootApplication.SpringBootStudent.Entity.Role;
import com.example.SpringBootApplication.SpringBootStudent.Entity.User;
import com.example.SpringBootApplication.SpringBootStudent.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {

	/*
	 * Object for the userRepository and The PasswordEncoader :-
	 */
	
	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

	@EventListener(ApplicationReadyEvent.class)
	public void InsertTheUser(ApplicationReadyEvent event) {

		User Employee = new User();
		Employee.setUsername("Employee");
		Employee.setPassword(passwordEncoder.encode("Emp123"));
		Role roleEmp = new Role();
		roleEmp.setRoleName("Employee");

		List<Role> list = new ArrayList<Role>();
		list.add(roleEmp);
		Employee.setListRole(list);

		User Admin = new User();
		Admin.setUsername("Admin");
		Admin.setPassword(passwordEncoder.encode("Add123"));

		Role roleAdd = new Role();
		roleAdd.setRoleName("Admin");
		List<Role> list2 = new ArrayList<>();
		list2.add(roleAdd);
		Admin.setListRole(list2);

		// save The Admin
		userRepository.save(Employee);
		userRepository.save(Admin);

	}

	/**
	 * Note:- After Saveing The user and The admin Now We have Two User
	 * (Employee,Admin);
	 */
	
	/*
	 * Now We will be Goining The UserDetailsImpl class and Provide The acsees To the user :-
	 */
}
