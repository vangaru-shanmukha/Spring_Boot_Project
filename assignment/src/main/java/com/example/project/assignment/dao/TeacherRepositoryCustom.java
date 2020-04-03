package com.example.project.assignment.dao;

import java.util.List;

import com.example.project.assignment.entity.Department;
import com.example.project.assignment.entity.Teacher;

public interface TeacherRepositoryCustom {
	
	public List<Teacher> findByDepartment(Department department);

}
