package com.example.project.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.assignment.dao.CourseRepository;
import com.example.project.assignment.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findById(int theId) {
		Optional<Course> result = courseRepository.findById(theId);
		Course theCourse = null;
		if(result.isPresent()) {
			theCourse = result.get();
		}
		else {
			throw new RuntimeException("Did not find course with id : " + theId);
		}
		return theCourse;
	}

	@Override
	public void save(Course theCourse) {
		courseRepository.save(theCourse);

	}

	@Override
	public void deleteById(int theId) {
		courseRepository.deleteById(theId);

	}

}
