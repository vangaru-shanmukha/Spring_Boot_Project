package spring.boot.project.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.project.demo2.entity.Course;
import spring.boot.project.demo2.entity.Department;
import spring.boot.project.demo2.entity.Student;
import spring.boot.project.demo2.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public List<Student> getStudents(){	
		return studentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable(value = "id") String rollNumber) {
		return studentService.findById(rollNumber);
	}
	
	@GetMapping("/{id}/department")
	public Department getDepartment(@PathVariable(value = "id") String rollNumber) {
		return studentService.findById(rollNumber).getDepartment();
	}
	
	@GetMapping("/{id}/courses")
	public List<Course> getCourses(@PathVariable(value = "id") String rollNumber) {
		return studentService.findById(rollNumber).getCourses();
	}
	
	@PutMapping("/addStudent")
	public void updateStudent(@RequestBody Student theStudent) {
		System.out.println(theStudent.getDepartment().getId());
		studentService.save(theStudent);
	}
	
}
