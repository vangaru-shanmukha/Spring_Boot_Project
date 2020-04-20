package com.neeraja.ShareMyOffer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraja.ShareMyOffer.entities.Login;

public interface LoginRepository extends JpaRepository<Login, String> {

}
