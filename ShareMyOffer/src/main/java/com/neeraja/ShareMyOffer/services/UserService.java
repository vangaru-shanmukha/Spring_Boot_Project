package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.User;

public interface UserService {

	List<User> findAll();

	User findById(int id);

	User save(User theUser);

	boolean deleteById(int id);
	
}
