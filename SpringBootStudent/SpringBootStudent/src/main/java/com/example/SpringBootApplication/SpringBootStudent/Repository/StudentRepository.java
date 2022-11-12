package com.example.SpringBootApplication.SpringBootStudent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.SpringBootApplication.SpringBootStudent.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
