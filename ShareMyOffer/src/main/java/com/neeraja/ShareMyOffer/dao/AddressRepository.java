package com.neeraja.ShareMyOffer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraja.ShareMyOffer.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
