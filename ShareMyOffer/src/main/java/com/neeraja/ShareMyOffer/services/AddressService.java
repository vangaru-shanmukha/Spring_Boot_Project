package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Address;

public interface AddressService {
	
	List<Address> findAll();

	Address findById(int id);

	Address save(Address theAddress);

	boolean deleteById(int id);

}
