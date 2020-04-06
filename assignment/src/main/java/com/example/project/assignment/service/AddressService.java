package com.example.project.assignment.service;

import java.util.List;

import com.example.project.assignment.entity.Address;

public interface AddressService {

	public List<Address> findAll();

	public Address findById(int theZipCode);

	public void save(Address theAddress);

	public void deleteById(int theZipCode);
	
}
