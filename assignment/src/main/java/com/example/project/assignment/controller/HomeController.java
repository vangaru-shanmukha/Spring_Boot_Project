package com.example.project.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.assignment.service.AdminService;
import com.example.project.assignment.service.StudentService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/profile")
	public String getProfile(Model theModel) { 
		System.out.println("hello");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		String currentPrincipalRole = authentication.getAuthorities().toString();
		System.out.println(currentPrincipalName);
		if(currentPrincipalRole.contains("ROLE_ADMIN")) {
			theModel.addAttribute("user", adminService.findById(currentPrincipalName));
		}
		else if(currentPrincipalRole.contains("ROLE_STUDENT")) {
			theModel.addAttribute("user", studentService.findById(currentPrincipalName));
		}
		return "profile-page.html";
	}
}
