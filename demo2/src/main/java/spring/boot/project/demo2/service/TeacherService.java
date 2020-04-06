package spring.boot.project.demo2.service;

import java.util.List;

import spring.boot.project.demo2.entity.Department;
import spring.boot.project.demo2.entity.Teacher;

public interface TeacherService {

	public List<Teacher> findAll();

	public Teacher findById(String email);

	public void save(Teacher theTeacher);

	public void deleteById(String email);
	
	public List<Teacher> findByDepartment(Department department);
}
