package com.example.project.assignment.service;

import java.util.List;

import com.example.project.assignment.entity.Department;

public interface DepartmentService {
	
	public List<Department> findAll();

	public Department findById(int theDepartmentId);

	public void save(Department theDepartment);

	public void deleteById(int theDepartmentId);

}
