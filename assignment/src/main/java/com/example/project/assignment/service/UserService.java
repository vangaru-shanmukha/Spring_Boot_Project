package com.example.project.assignment.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.project.assignment.entity.User;

public interface UserService extends UserDetailsService {

	public List<User> findAll();

	public User findById(String userName);

	public void save(User theUser);

	public void deleteById(String userName);
}
