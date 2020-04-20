package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.Offer;

public interface OfferService {

	List<Offer> findAll();

	Offer findById(int id);

	Offer save(Offer theOffer);

	boolean deleteById(int id);
	
}
