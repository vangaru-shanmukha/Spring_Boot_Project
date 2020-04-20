package com.neeraja.ShareMyOffer.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neeraja.ShareMyOffer.dao.LoginRepository;
import com.neeraja.ShareMyOffer.entities.Login;
import com.neeraja.ShareMyOffer.entities.Role;

@Service
public class AuthServiceImpl implements AuthService {
	
	private static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Login> result = loginRepository.findById(userName);
		logger.info(result.toString());
		Login login = null;
		if (result.isPresent() == false) {
			throw new UsernameNotFoundException("Invalid username / password.");
		}
		login = result.get();
		return new org.springframework.security.core.userdetails.User(login.getUserName(), login.getPassword(),
				mapRolesToAuthorities(login.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

	@Override
	public List<Login> findAll() {
		return loginRepository.findAll();
	}

	@Override
	public Login findById(String userName) {
		Optional<Login> result = loginRepository.findById(userName);
		Login login = null;
		if(result.isPresent()) {
			login = result.get();
		}
		else {
			throw new RuntimeException("Did not find a user");
		}
		return login;
	}

	@Override
	public Login save(Login theLogin) {
		loginRepository.save(theLogin);
		return theLogin;
		
	}

	@Override
	public boolean deleteById(String userName) {
		loginRepository.deleteById(userName);
		return true;
	}

}
