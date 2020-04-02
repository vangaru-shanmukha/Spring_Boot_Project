package com.example.project.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.assignment.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
