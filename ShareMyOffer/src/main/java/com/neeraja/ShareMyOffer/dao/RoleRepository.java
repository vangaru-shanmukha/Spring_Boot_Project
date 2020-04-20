package com.neeraja.ShareMyOffer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neeraja.ShareMyOffer.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByRoleName(String roleName);
}
