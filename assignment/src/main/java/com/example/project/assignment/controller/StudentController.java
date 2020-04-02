package com.example.project.assignment.controller;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.assignment.dao.RoleRepository;
import com.example.project.assignment.entity.Address;
import com.example.project.assignment.entity.Department;
import com.example.project.assignment.entity.Student;
import com.example.project.assignment.entity.User;
import com.example.project.assignment.service.AddressService;
import com.example.project.assignment.service.DepartmentService;
import com.example.project.assignment.service.StudentService;
import com.example.project.assignment.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private List<Department> departments;
	
	private List<Address> addresses;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@PostConstruct
	public void fillValues() {
		departments = departmentService.findAll();
		addresses = addressService.findAll();
	}
	@GetMapping("/list")
	public String listAllStudents(Model theModel) {
		List<Student> students = studentService.findAll();
		theModel.addAttribute("students", students);
		return "students/list-students";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model theModel) {
		theModel.addAttribute("student", new Student());
		theModel.addAttribute("departments", departments);
		theModel.addAttribute("addresses", addresses);
		return "students/add-student";
	}
	
	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult, Model theModel) {
		String rollNumber = theStudent.getRollNumber();
		logger.info("Processing registration form for: " + rollNumber);
		theModel.addAttribute("departments", departments);
		theModel.addAttribute("addresses", addresses);
		// form validation
		if(theBindingResult.hasErrors()) {
			System.out.println("errors");
			return "add-student";
		}
		
		// check the database if the student already exists
		Student existingStudent = null;
		try {
			existingStudent = studentService.findById(rollNumber);
			System.out.println("try");
		} catch (RuntimeException e) {
			// create student
			System.out.println("catch");
			User user = new User();
			user.setUserName(rollNumber);
			String date = theStudent.getDateOfBirth().replaceAll("-", "");
			user.setPassword(passwordEncoder.encode(date));
			user.setRoles(Arrays.asList(roleRepository.findByRoleName("ROLE_STUDENT")));
			userService.save(user);
			System.out.println(user.toString());
			System.out.println("user saved");
			studentService.save(theStudent);
		} finally {
			if (existingStudent != null) {
				theModel.addAttribute("addStudentError", "Student with " + rollNumber + " exists already");
				logger.warning("Student already exists");
				theModel.addAttribute("student", new Student());
				return "add-student";
			}
		}
		logger.info("Successfully added!");
		return "confirmation";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("rollNumber") String theRollNumber, Model theModel) {
		
		Student theStudent = studentService.findById(theRollNumber);
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("departments", departments);
		theModel.addAttribute("addresses", addresses);
		return "students/update-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult, Model theModel) {
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("departments", departments);
		theModel.addAttribute("addresses", addresses);
		if(theBindingResult.hasErrors()) {
			return "/students/update-form";
		}
		studentService.save(theStudent);
		return "confirmation";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("rollNumber") String theRollNumber) {
		
		studentService.deleteById(theRollNumber);
		
		userService.deleteById(theRollNumber);
		return "confirmation";
		
	}
}
