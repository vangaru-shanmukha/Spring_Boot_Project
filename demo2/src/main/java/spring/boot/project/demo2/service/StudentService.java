package spring.boot.project.demo2.service;

import java.util.List;

import spring.boot.project.demo2.entity.Department;
import spring.boot.project.demo2.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(String theRollNo);
	
	public void save(Student theStudent);
	
	public void deleteById(String theRollNo);
	
	public List<Student> findByDepartment(Department theDepartment);
	
}
