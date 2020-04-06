package com.example.project.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.assignment.dao.AdminRepository;
import com.example.project.assignment.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;
	
	@Autowired
	public AdminServiceImpl(AdminRepository theAdminRepository) {
		adminRepository = theAdminRepository;
	}
	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public Admin findById(String theEmail) {
		Optional<Admin> result = adminRepository.findById(theEmail);
		Admin theAdmin = null;
		if(result.isPresent()) {
			theAdmin = result.get();
		}
		else {
			throw new RuntimeException("Did not find admin with email : " + theEmail);
		}
		return theAdmin;
	}

	@Override
	public void save(Admin theAdmin) {
		adminRepository.save(theAdmin);

	}

	@Override
	public void deleteById(String theEmail) {
		adminRepository.deleteById(theEmail);

	}

}
