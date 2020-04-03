package com.example.project.assignment.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.project.assignment.entity.Course;
import com.example.project.assignment.entity.Department;
import com.example.project.assignment.entity.Teacher;
import com.example.project.assignment.entity.User;
import com.example.project.assignment.service.AddressService;
import com.example.project.assignment.service.CourseService;
import com.example.project.assignment.service.DepartmentService;
import com.example.project.assignment.service.TeacherService;
import com.example.project.assignment.service.UserService;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private static Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	@GetMapping("/list")
	public String listAllStudents(Model theModel) {
		List<Teacher> teachers = teacherService.findAll();
		theModel.addAttribute("teachers", teachers);
		return "teachers/list-teachers";
	}
	
	@GetMapping("/addTeacher")
	public String addTeacher(Model theModel) {
		List<Department> departments = departmentService.findAll();
		List<Address> addresses = addressService.findAll();
		theModel.addAttribute("teacher", new Teacher());
		theModel.addAttribute("departments", departments);
		theModel.addAttribute("addresses", addresses);
		List<Course> courses = courseService.findAll();
		theModel.addAttribute("courses", courses);
		return "teachers/add-teacher";
	}
	
	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("teacher") Teacher theTeacher, BindingResult theBindingResult, Model theModel) {
		List<Department> departments = departmentService.findAll();
		List<Address> addresses = addressService.findAll();
		String email = theTeacher.getEmail();
		logger.info("Processing registration form for: " + email);
		theModel.addAttribute("departments", departments);
		theModel.addAttribute("addresses", addresses);
		// form validation
		if(theBindingResult.hasErrors()) {
			return "teachers/add-teacher";
		}
		
		// check the database if the teacher already exists
		Teacher existingStudent = null;
		try {
			existingStudent = teacherService.findById(email);
		} catch (RuntimeException e) {
			// create teacher
			User user = new User();
			user.setUserName(email);
			String date = theTeacher.getDateOfBirth().replaceAll("-", "");
			user.setPassword(passwordEncoder.encode(date));
			user.setRoles(Arrays.asList(roleRepository.findByRoleName("ROLE_TEACHER")));
			userService.save(user);
			teacherService.save(theTeacher);
		} finally {
			if (existingStudent != null) {
				theModel.addAttribute("addTeacherError", "Teacher with " + email + " exists already");
				logger.info("Teacher already exists");
				theModel.addAttribute("teacher", new Teacher());
				return "teachers/add-teacher";
			}
		}
		logger.info("Successfully added!");
		return "confirmation";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("email") String theEmail, Model theModel) {
		List<Department> departments = departmentService.findAll();
		List<Address> addresses = addressService.findAll();
		Teacher theTeacher = teacherService.findById(theEmail);
		List<Course> teacherCourses = theTeacher.getCourses();
		List<Course> courses = courseService.findAll();
		List<Department> teacherDepartments = theTeacher.getDepartments();
		theModel.addAttribute("teacher", theTeacher);
		theModel.addAttribute("departments", departments);
		theModel.addAttribute("addresses", addresses);
		theModel.addAttribute("courses", courses);
		theModel.addAttribute("teacherCourses", teacherCourses);
		theModel.addAttribute("teacherDepartments", teacherDepartments);
		return "teachers/update-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@Valid @ModelAttribute("teacher") Teacher theTeacher, BindingResult theBindingResult, Model theModel) {
		
		List<Department> departments = departmentService.findAll();
		List<Address> addresses = addressService.findAll();
		List<Course> teacherCourses = theTeacher.getCourses();
		List<Course> courses = courseService.findAll();
		List<Department> teacherDepartments = theTeacher.getDepartments();
		theModel.addAttribute("teacher", theTeacher);
		theModel.addAttribute("departments", departments);
		theModel.addAttribute("addresses", addresses);
		theModel.addAttribute("courses", courses);
		theModel.addAttribute("teacherCourses", teacherCourses);
		theModel.addAttribute("teacherDepartments", teacherDepartments);
		theModel.addAttribute("departments", departments);
		theModel.addAttribute("addresses", addresses);
		
		if(theBindingResult.hasErrors()) {
			return "/teachers/update-form";
		}
		teacherService.save(theTeacher);
		return "confirmation";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("email") String theEmail) {
		
		teacherService.deleteById(theEmail);
		
		userService.deleteById(theEmail);
		return "confirmation";
		
	}
}
