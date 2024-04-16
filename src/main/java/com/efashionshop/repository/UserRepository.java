package com.efashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efashionshop.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findByEmail(String email);

}
