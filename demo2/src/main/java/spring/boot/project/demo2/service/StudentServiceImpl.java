package spring.boot.project.demo2.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.project.demo2.dao.StudentRepository;
import spring.boot.project.demo2.entity.Department;
import spring.boot.project.demo2.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	private static Logger logger = LoggerFactory.getLogger(StudentService.class);

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
		logger.info(theStudent.getDepartment().toString());
		
		studentRepository.save(theStudent);

	}

	@Override
	public void deleteById(String theRollNo) {
		studentRepository.deleteById(theRollNo);

	}

	@Override
	public List<Student> findByDepartment(Department theDepartment) {
		return studentRepository.findByDepartment(theDepartment);
		
	}

}
