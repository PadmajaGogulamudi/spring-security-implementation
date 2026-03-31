package com.example.springSecurityApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springSecurityApplication.model.Users;

public interface UserRepo extends JpaRepository<Users,Integer> {

	public Users findByUsername(String username);

}
