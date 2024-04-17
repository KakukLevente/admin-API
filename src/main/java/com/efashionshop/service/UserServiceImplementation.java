package com.efashionshop.service;

import java.util.List;
import java.util.Optional;

import com.efashionshop.repository.CartRepository;
import org.springframework.stereotype.Service;

import com.efashionshop.config.JwtProvider;
import com.efashionshop.exception.UserException;
import com.efashionshop.model.User;
import com.efashionshop.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	private CartRepository cartRepository;
	
	public UserServiceImplementation(UserRepository userRepository,JwtProvider jwtProvider, CartRepository cartRepository) {
		this.userRepository=userRepository;
		this.jwtProvider=jwtProvider;
		this.cartRepository=cartRepository;
	}

	@Override
	public User FindUserById(Long userId) throws UserException {
		
		Optional<User>user=userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("user not found with id :"+userId);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email=jwtProvider.getEmailFromToken(jwt);
		
		User user=userRepository.findByEmail(email);
		
		if(user==null) {
			throw new UserException("user not found with email"+email);
		}
		return user;
	}


	public List<User> findAll() throws UserException{
		List<User> users = userRepository.findAll();

		return users;
	}

	public void delete(User user) throws UserException{
		cartRepository.delete(cartRepository.findByUserId(user.getId()));
		userRepository.delete(user);
	}

	public void update(User user) throws UserException{
		userRepository.save(user);
	}

}
