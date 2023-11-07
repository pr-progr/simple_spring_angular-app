package com.example.service;

import java.util.List;

import com.example.model.Student;
import com.example.repositoory.StudentRepository;


public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() {
		return (List<Student>) studentRepository.findAll();
	}
	
	public void saveOrUpdate(Student student) {
		studentRepository.save(student);
	}
	
	public void delete(Student student) {
		studentRepository.delete(student);
	}
}
