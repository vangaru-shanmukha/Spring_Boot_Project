package spring.boot.project.demo2.service;

import java.util.List;

import spring.boot.project.demo2.entity.Course;
import spring.boot.project.demo2.entity.Department;

public interface CourseService {

	List<Course> findAll();

	Course findById(int theId);

	Course save(Course theCourse);

	Course deleteById(int theId);
	
	List<Course> findByDepartment(Department department);
}
