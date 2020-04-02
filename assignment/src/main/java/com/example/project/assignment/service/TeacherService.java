package com.example.project.assignment.service;

import java.util.List;

import com.example.project.assignment.entity.Teacher;

public interface TeacherService {

	public List<Teacher> findAll();

	public Teacher findById(String email);

	public void save(Teacher theTeacher);

	public void deleteById(String email);
}
