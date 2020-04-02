package com.example.project.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.assignment.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
