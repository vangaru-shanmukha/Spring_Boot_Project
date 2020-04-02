package com.example.project.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.assignment.dao.StudentRepository;
import com.example.project.assignment.entity.Department;
import com.example.project.assignment.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(String theRollNo) {
		Optional<Student> result = studentRepository.findById(theRollNo);
		
		Student theStudent = null;
		
		if (result.isPresent()) {
			theStudent = result.get();
		}
		else {
			// we didn't find the student
			throw new RuntimeException("Did not find student with roll number - " + theRollNo);
		}
		
		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		System.out.println(theStudent.getDepartment());
		
		studentRepository.save(theStudent);

	}

	@Override
	public void deleteById(String theRollNo) {
		studentRepository.deleteById(theRollNo);

	}

	@Override
	public void findByDepartment(Department theDepartment) {
		studentRepository.findByDepartment(theDepartment);
		
	}

}
