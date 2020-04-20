package com.neeraja.ShareMyOffer.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neeraja.ShareMyOffer.dto.UserDTO;
import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult theBindingResult,
			Model theModel) {
		logger.info(userDTO.getFirstName());
		User user = new User();
		Address address = new Address();
		
		// form validation
		if (theBindingResult.hasErrors()) {
			return "signup-page";
		}
		
		return "confirmation-page";
	}
}
