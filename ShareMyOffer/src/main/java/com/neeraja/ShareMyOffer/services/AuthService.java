package com.neeraja.ShareMyOffer.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.neeraja.ShareMyOffer.entities.Login;

public interface AuthService extends UserDetailsService {

	List<Login> findAll();

	Login findById(String userName);

	Login save(Login theLogin);

	boolean deleteById(String userName);
	
}
