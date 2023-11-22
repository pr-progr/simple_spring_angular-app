package com.example.repositoory;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
