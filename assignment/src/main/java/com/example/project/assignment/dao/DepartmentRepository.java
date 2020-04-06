package com.example.project.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.assignment.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
