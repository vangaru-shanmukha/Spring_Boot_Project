package com.neeraja.ShareMyOffer.services;

import java.util.List;

import com.neeraja.ShareMyOffer.entities.UserOffer;

public interface UserOfferService {

	List<UserOffer> findAll();

	UserOffer findById(int id);

	UserOffer save(UserOffer theUserOffer);

	boolean deleteById(int id);
	
}
