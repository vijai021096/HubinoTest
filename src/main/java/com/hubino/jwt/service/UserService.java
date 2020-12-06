package com.hubino.jwt.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.hubino.jwt.controllers.ResponseApi;
import com.hubino.jwt.model.Address;
import com.hubino.jwt.model.Department;
import com.hubino.jwt.model.Role;
import com.hubino.jwt.model.UserEntity;
import com.hubino.jwt.repository.DepartmentRepository;
import com.hubino.jwt.repository.RoleRepository;
import com.hubino.jwt.repository.UserRepository;
import com.hubino.jwt.request.RegisterRequest;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	private static RestTemplate restTemplate = new RestTemplate();
	 private static final String baseURL = "http://api.ipstack.com/134.201.250.155?access_key=626053333c5203dcd83c391d63485afb";
	
	UserDetails findByUSerName(String userName) {
		UserEntity user =  userRepository.findByEmail(userName);
		return new User(user.getEmail(),user.getPassword(),Arrays.asList(new SimpleGrantedAuthority("ROLE_"+user.getRole().getRole())));
	}
	
	public ResponseApi registerUser(RegisterRequest req) {	
	if((null==userRepository.findByEmail(req.getEmail()))&&(null==userRepository.findByUserName(req.getUserName()))){
		UserEntity user = new UserEntity(req.getUserName(), req.getEmail(), encoder.encode(req.getPassword()));
		Role role=roleRepository.findByRole(req.getRole()).get();
		Department dept=departmentRepository.findByDeptName(req.getDepartment());
		user.setRole(role);
		user.setDepartment(dept);
		userRepository.save(user);
		return new ResponseApi("User registered");
	}
	else {
		return new ResponseApi("User Already found");
	}
		
	}
	
	public userResponse getUserDetails() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name=auth.getName();
		UserEntity user=userRepository.findByEmail(name);
		Address address = getAddress();
		return new userResponse(user.getUserName(),user.getDepartment().getDeptName(),user.getRole().getRole(),address.getCity(),address.getState(),address.getCountry());
		
	}
	
	public Address getAddress(){
		Address result = restTemplate.getForObject(baseURL, Address.class);
		return result;
	}
}
