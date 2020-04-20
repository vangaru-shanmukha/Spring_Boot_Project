package com.neeraja.ShareMyOffer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.dao.RoleRepository;
import com.neeraja.ShareMyOffer.entities.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(int id) {
		Optional<Role> result = roleRepository.findById(id);
		Role role = null;
		if(result.isPresent()) {
			role = result.get();
		}
		else {
			throw new RuntimeException("Did not find a role");
		}
		return role;
	}

	@Override
	public Role save(Role theRole) {
		roleRepository.save(theRole);
		return theRole;
	}

	@Override
	public boolean deleteById(int id) {
		roleRepository.deleteById(id);
		return true;
	}

}
