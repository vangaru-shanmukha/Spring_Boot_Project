package spring.boot.project.demo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.project.demo2.dao.TeacherRepository;
import spring.boot.project.demo2.entity.Department;
import spring.boot.project.demo2.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher findById(String email) {
		Optional<Teacher> result = teacherRepository.findById(email);
		Teacher theTeacher = null;
		if(result.isPresent()) {
			theTeacher = result.get();
		}
		else {
			throw new RuntimeException("Did not find teacher with email: " + email);
		}
		return theTeacher;
	}

	@Override
	public void save(Teacher theTeacher) {
		teacherRepository.save(theTeacher);

	}

	@Override
	public void deleteById(String email) {
		teacherRepository.deleteById(email);

	}

	@Override
	public List<Teacher> findByDepartment(Department department) {
		return teacherRepository.findByDepartment(department);
	}

}
