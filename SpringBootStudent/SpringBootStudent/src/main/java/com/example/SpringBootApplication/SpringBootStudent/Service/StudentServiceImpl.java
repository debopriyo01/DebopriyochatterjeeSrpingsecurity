package com.example.SpringBootApplication.SpringBootStudent.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootApplication.SpringBootStudent.Entity.Student;
import com.example.SpringBootApplication.SpringBootStudent.Repository.StudentRepository;

@Service
public class StudentServiceImpl {

	@Autowired
	 private StudentRepository studentRepository;

	public List<Student> FeatchAllStudent() {
		return this.studentRepository.findAll();
	}

	public Optional<Student> findbyid(int id) {
		return this.studentRepository.findById(id);
	}

	public Student save(Student student) {
		return this.studentRepository.saveAndFlush(student);
	}

	public void delete(Student student) {

		this.studentRepository.delete(student);
	}
}
