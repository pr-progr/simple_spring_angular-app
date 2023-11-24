package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;

import jakarta.persistence.metamodel.StaticMetamodel;

@RestController
//@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/v1/universita")
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping(value = "/students")
	public List<Student> getList() {
		return (List<Student>) studentService.getStudents();
	}

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/addstudent")
	public void save(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
	}
}
