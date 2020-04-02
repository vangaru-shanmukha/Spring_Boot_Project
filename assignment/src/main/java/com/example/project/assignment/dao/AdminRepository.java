package com.example.project.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.assignment.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, String> {

}
