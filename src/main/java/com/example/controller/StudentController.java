package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.repositoory.StudentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {
	
	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@GetMapping(value = "/students")
	public List<Student> getList() {
		return (List<Student>) studentRepository.findAll();
	}

	@PostMapping(value = "/students")
	public void save(@RequestBody Student student) {
		studentRepository.save(student);
	}
}
