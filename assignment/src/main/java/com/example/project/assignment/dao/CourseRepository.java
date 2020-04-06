package com.example.project.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.assignment.entity.Course;
import com.example.project.assignment.entity.Department;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	List<Course> findByDepartment(Department department);
	
}
