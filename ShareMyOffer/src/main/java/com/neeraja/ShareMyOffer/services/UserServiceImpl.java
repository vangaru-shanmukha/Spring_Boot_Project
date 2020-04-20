package com.neeraja.ShareMyOffer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.dao.UserRepository;
import com.neeraja.ShareMyOffer.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		Optional<User> result = userRepository.findById(id);
		User user = null;
		if(result.isPresent()) {
			user = result.get();
		}
		else {
			throw new RuntimeException("Did not find a user");
		}
		return user;
	}

	@Override
	public User save(User theUser) {
		userRepository.save(theUser);
		return theUser;
	}

	@Override
	public boolean deleteById(int id) {
		userRepository.deleteById(id);
		return true;
	}

}
