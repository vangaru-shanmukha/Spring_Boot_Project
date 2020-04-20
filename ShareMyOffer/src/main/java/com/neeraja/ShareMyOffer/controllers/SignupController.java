package com.neeraja.ShareMyOffer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neeraja.ShareMyOffer.dto.UserDTO;

@Controller
@RequestMapping("/signup")
public class SignupController {

	@GetMapping("/showMySignUpPage")
	public String showMySignUpPage(Model theModel) {
		UserDTO userDTO = new UserDTO();
		theModel.addAttribute("user", userDTO);
		return "signup-page";
	}
}
