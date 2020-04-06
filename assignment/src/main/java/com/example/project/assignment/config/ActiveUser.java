package com.example.project.assignment.config;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.project.assignment.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActiveUser {

	private String userName;
	private List<Role> roles;
	
}
