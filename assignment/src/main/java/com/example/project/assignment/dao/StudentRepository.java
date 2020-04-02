package com.example.project.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.project.assignment.entity.Department;
import com.example.project.assignment.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	
	@Query("SELECT s FROM Student s WHERE s.department = ?1")
	List<Student> findByDepartment(Department department);

}
