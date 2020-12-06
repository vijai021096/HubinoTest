package com.hubino.jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hubino.jwt.model.Address;
import com.hubino.jwt.repository.AddressRepository;
import com.hubino.jwt.request.RegisterRequest;
import com.hubino.jwt.service.AddressService;
import com.hubino.jwt.service.UserService;
import com.hubino.jwt.service.userResponse;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@PostMapping("/authenticate/registerUser")
	public ResponseApi saveUser(@RequestBody RegisterRequest req) {
		return userService.registerUser(req);
	}
	
	@GetMapping("/address")
	public Address getAddress()
	{  
		Address address=userService.getAddress();   
		return new Address( address.getCity(),address.getState(),address.getCountry());
	}
	
	@PostMapping("/admin/saveAddress")
	public ResponseApi postAddress() {
		return addressService.saveAddress();
		
	}
	
	
	@GetMapping("/getUserDetails")
	public userResponse getUserDetails() {
		return userService.getUserDetails();
	}
	
	
}
