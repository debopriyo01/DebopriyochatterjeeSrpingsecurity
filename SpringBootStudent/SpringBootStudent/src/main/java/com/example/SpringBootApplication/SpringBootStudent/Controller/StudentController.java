package com.example.SpringBootApplication.SpringBootStudent.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringBootApplication.SpringBootStudent.Entity.Student;
import com.example.SpringBootApplication.SpringBootStudent.Service.StudentServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/Stduents")
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@GetMapping("/List")
	public String FindAll(Model model) {

		List<Student> students = studentServiceImpl.FeatchAllStudent();
		model.addAttribute("students", students);
		return "List_of_Student";
	}

	@GetMapping("/Studentform")
	public String showStudentForm(Model model) {

		Student student2 = new Student();
		model.addAttribute("student", student2);
		return "StudentForm";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {

		this.studentServiceImpl.save(student);
		return "redirect:/Stduents/List";

	}

	@PutMapping("/Update")
	public String updateStudent(@RequestParam("id") int id, Model model) {

		Optional<Student> studOptional = studentServiceImpl.findbyid(id);

		Student student = studOptional.get();
		student.setName(student.getName());
		student.setDepartment(student.getDepartment());
		student.setCountry(student.getCountry());
		model.addAttribute("student", student);
		this.studentServiceImpl.save(student);
		return "redirect:/Stduents/List";

	}

	@DeleteMapping("/Delete")
	public void deleteStudent(@RequestParam("id") int id) {

		Optional<Student> student = studentServiceImpl.findbyid(id);
		this.studentServiceImpl.delete(student.get());

	}

	@GetMapping("/Error")
	public String Error() {
		return "Acsees-Denied";
	}

}
