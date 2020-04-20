package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Role;

public interface RoleService {
	
	List<Role> findAll();

	Role findById(int id);

	Role save(Role theRole);

	boolean deleteById(int id);

}
