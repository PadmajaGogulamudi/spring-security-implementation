package com.example.springSecurityApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springSecurityApplication.model.Users;
import com.example.springSecurityApplication.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	@Autowired
	private PasswordEncoder encoder;// getting it from springCOnfig class
	//BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(strength:12);    (4 to 31)
	
	public Users register(Users user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		return repo.save(user);
	}

}
