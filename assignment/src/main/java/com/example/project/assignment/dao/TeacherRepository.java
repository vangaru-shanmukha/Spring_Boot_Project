package com.example.project.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.assignment.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
