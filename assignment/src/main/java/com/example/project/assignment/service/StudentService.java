package com.example.project.assignment.service;

import java.util.List;

import com.example.project.assignment.entity.Department;
import com.example.project.assignment.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(String theRollNo);
	
	public void save(Student theStudent);
	
	public void deleteById(String theRollNo);
	
	public List<Student> findByDepartment(Department theDepartment);
	
}
