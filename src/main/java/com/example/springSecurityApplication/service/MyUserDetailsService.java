package com.example.springSecurityApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springSecurityApplication.model.UserPrinciple;
import com.example.springSecurityApplication.model.Users;
import com.example.springSecurityApplication.repo.UserRepo;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepo userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("username from request :"+username);
		Users user=userrepo.findByUsername(username);
		if(user==null) {
			System.out.println("user not found in load user by username");
			throw new UsernameNotFoundException("user not found in load user by username");
		}
		
		return new UserPrinciple(user);
	}

}
