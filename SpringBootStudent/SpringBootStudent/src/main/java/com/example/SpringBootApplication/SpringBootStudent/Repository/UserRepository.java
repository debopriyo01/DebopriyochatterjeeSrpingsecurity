package com.example.SpringBootApplication.SpringBootStudent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.SpringBootApplication.SpringBootStudent.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/*
	 * Declaring Only the method:-
	 */
	public User findByUserName(String username);
}
