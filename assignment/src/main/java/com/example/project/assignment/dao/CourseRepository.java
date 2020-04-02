package com.example.project.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.assignment.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
