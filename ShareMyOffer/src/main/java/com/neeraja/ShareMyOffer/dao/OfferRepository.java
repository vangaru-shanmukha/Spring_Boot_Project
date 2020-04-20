package com.neeraja.ShareMyOffer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraja.ShareMyOffer.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
