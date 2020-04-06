package com.example.project.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.assignment.dao.AddressRepository;
import com.example.project.assignment.entity.Address;


@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address findById(int theZipCode) {
		Optional<Address> result = addressRepository.findById(theZipCode);
		Address theAddress = null;
		if(result.isPresent()) {
			theAddress = result.get();
		}
		else {
			throw new RuntimeException("Did not find address with zipcode : " + theZipCode);
		}
		return theAddress;
	}

	@Override
	public void save(Address theAddress) {
		addressRepository.save(theAddress);

	}

	@Override
	public void deleteById(int theZipCode) {
		addressRepository.deleteById(theZipCode);

	}

}
