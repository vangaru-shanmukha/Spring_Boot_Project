package com.neeraja.ShareMyOffer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.dao.OfferRepository;
import com.neeraja.ShareMyOffer.entities.Offer;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	@Override
	public List<Offer> findAll() {
		return offerRepository.findAll();
	}

	@Override
	public Offer findById(int id) {
		Optional<Offer> result = offerRepository.findById(id);
		Offer offer = null;
		if(result.isPresent()) {
			offer = result.get();
		}
		else {
			throw new RuntimeException("Did not find a offer");
		}
		return offer;
	}

	@Override
	public Offer save(Offer theOffer) {
		offerRepository.save(theOffer);
		return theOffer;
	}

	@Override
	public boolean deleteById(int id) {
		offerRepository.deleteById(id);
		return true;
	}

}
