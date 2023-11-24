package com.example.bootstrap;

import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.model.Student;
import com.example.service.StudentService;

@Component
public class Runner implements CommandLineRunner{
	
	private final StudentService studentService;
	
	

	public Runner(StudentService studentService) {
		this.studentService = studentService;
	}



	@Override
	public void run(String... args) throws Exception {
		Student s = new Student();
		s.setNome("Mario");
		s.setCognome("Rossi");
		//studentService.saveOrUpdate(s);
	}

}
