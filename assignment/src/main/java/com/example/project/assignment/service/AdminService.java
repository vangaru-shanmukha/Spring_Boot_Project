package com.example.project.assignment.service;

import java.util.List;

import com.example.project.assignment.entity.Admin;

public interface AdminService {

	public List<Admin> findAll();

	public Admin findById(String theEmail);

	public void save(Admin theAdmin);

	public void deleteById(String theEmail);
}
