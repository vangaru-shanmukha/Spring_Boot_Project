package com.example.project.assignment.service;

import java.util.List;

import com.example.project.assignment.entity.Course;
import com.example.project.assignment.entity.Department;

public interface CourseService {

	List<Course> findAll();

	Course findById(int theId);

	Course save(Course theCourse);

	Course deleteById(int theId);
	
	List<Course> findByDepartment(Department department);
}
