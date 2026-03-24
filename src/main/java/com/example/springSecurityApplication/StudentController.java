package com.example.springSecurityApplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	List<Student> students = new ArrayList<>(List.of(new Student(1, "paddu", "IT"), new Student(2, "nani", "cse")));

	@GetMapping("/hello")
	public String getMessage(HttpServletRequest request) {
		return "hello this is " + request.getSession().getId();
	}

	@GetMapping("/getAll")
	public List<Student> getStudents() {
		return students;
	}
	
	@PostMapping("/saveStu")
	public Student saveStudent(@RequestBody Student stu) {
		students.add(stu);
		return stu;
	}
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");
	}

}
