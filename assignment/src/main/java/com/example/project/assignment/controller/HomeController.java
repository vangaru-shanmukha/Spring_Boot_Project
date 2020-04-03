package com.example.project.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.assignment.service.AdminService;
import com.example.project.assignment.service.StudentService;
import com.example.project.assignment.service.TeacherService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/profile")
	public String getProfile(Model theModel) { 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		String currentPrincipalRole = authentication.getAuthorities().toString();
		logger.info(currentPrincipalName);
		if(currentPrincipalRole.contains("ROLE_ADMIN")) {
			theModel.addAttribute("user", adminService.findById(currentPrincipalName));
		}
		else if(currentPrincipalRole.contains("ROLE_STUDENT")) {
			theModel.addAttribute("user", studentService.findById(currentPrincipalName));
		}
		else if(currentPrincipalRole.contains("ROLE_TEACHER")) {
			theModel.addAttribute("user", teacherService.findById(currentPrincipalName));
		}
		return "profile-page.html";
	}
}
