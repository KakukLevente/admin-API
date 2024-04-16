package com.efashionshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.efashionshop.exception.UserException;
import com.efashionshop.model.User;
import com.efashionshop.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public ResponseEntity<User>getUserProfileHandler(@RequestHeader("Authorization")String jwt)throws UserException{
		
		User user=userService.findUserProfileByJwt(jwt);
		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<User>>getAllUsers(@RequestHeader("Authorization")String jwt )throws UserException{
		User currentUser = userService.findUserProfileByJwt(jwt);

		if(currentUser.getRole().equals("ADMIN")){
			List<User> users = userService.findAll();
			return new ResponseEntity<List<User>>(users,HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<List<User>>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/customers")
	public ResponseEntity<List<User>> deleteUser(@RequestHeader("Authorization")String jwt, @RequestBody User user ) throws UserException{
		User currentUser = userService.findUserProfileByJwt(jwt);

		if(currentUser.getRole().equals("ADMIN")){
			userService.delete(user);
			List<User> users = userService.findAll();
			return new ResponseEntity<List<User>>(users,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<List<User>>(HttpStatus.FORBIDDEN);

	}

	@PutMapping("/customers")
	public ResponseEntity<List<User>> updateUser(@RequestHeader("Authorization")String jwt, @RequestBody User user ) throws UserException{
		User currentUser = userService.findUserProfileByJwt(jwt);

		if(currentUser.getRole().equals("ADMIN")){
			userService.update(user);
			List<User> users = userService.findAll();
			return new ResponseEntity<List<User>>(users,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<List<User>>(HttpStatus.FORBIDDEN);
	}

}
