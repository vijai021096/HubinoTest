package com.hubino.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hubino.jwt.controllers.ResponseApi;
import com.hubino.jwt.model.Address;
import com.hubino.jwt.model.UserEntity;
import com.hubino.jwt.repository.AddressRepository;
import com.hubino.jwt.repository.UserRepository;

@Service
public class AddressService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public ResponseApi saveAddress() {
		Address address = userService.getAddress();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name=auth.getName();
		UserEntity user=userRepository.findByEmail(name);
		address.setUserEntity(user);
		addressRepository.save(address);
		return new ResponseApi("Address Updated");
	}
}
