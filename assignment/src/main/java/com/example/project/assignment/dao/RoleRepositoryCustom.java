package com.example.project.assignment.dao;

import com.example.project.assignment.entity.Role;

public interface RoleRepositoryCustom {

	Role findByRoleName(String theRole);	
	
}
