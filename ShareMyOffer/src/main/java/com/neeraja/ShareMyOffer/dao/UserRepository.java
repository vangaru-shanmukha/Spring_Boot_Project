package com.neeraja.ShareMyOffer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraja.ShareMyOffer.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
