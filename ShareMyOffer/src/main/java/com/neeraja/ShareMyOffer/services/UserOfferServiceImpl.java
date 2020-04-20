package com.neeraja.ShareMyOffer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.dao.UserOfferRepository;
import com.neeraja.ShareMyOffer.entities.UserOffer;

@Service
public class UserOfferServiceImpl implements UserOfferService {

	@Autowired
	private UserOfferRepository userOfferRepository;
	
	@Override
	public List<UserOffer> findAll() {
		return userOfferRepository.findAll();
	}

	@Override
	public UserOffer findById(int id) {
		Optional<UserOffer> result = userOfferRepository.findById(id);
		UserOffer userOffer = null;
		if(result.isPresent()) {
			userOffer = result.get();
		}
		else {
			throw new RuntimeException("Did not find a user and offer");
		}
		return userOffer;
	}

	@Override
	public UserOffer save(UserOffer theUserOffer) {
		userOfferRepository.save(theUserOffer);
		return theUserOffer;
	}

	@Override
	public boolean deleteById(int id) {
		userOfferRepository.deleteById(id);
		return true;
	}

}
