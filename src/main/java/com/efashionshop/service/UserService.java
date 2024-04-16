package com.efashionshop.service;

import com.efashionshop.exception.UserException;
import com.efashionshop.model.User;

import java.util.List;

public interface UserService {
	
	public User FindUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;

	public List<User> findAll() throws UserException;

	public void delete(User user) throws UserException;

	public void update(User user) throws UserException;

}
