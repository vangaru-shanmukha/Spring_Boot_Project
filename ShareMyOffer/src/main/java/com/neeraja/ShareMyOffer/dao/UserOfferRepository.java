package com.neeraja.ShareMyOffer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraja.ShareMyOffer.entities.UserOffer;

public interface UserOfferRepository extends JpaRepository<UserOffer, Integer> {

}
