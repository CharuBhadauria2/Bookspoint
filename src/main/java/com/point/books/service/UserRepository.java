package com.point.books.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.point.books.entity.UserLogin;

public interface UserRepository extends JpaRepository<UserLogin,Integer> {
	
	UserLogin findByUsername(String username);
	
	UserLogin findById(long uid);
	
	UserLogin findByPassword(String password);
	

}
