package com.example.project.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.assignment.entity.Department;
import com.example.project.assignment.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	
	List<Student> findByDepartment(Department department);

}
