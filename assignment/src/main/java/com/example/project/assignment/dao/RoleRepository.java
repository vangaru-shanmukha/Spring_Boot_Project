package com.example.project.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.assignment.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>,RoleRepositoryCustom {

}
