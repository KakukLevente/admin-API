package com.efashionshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efashionshop.exception.CartItemException;
import com.efashionshop.exception.UserException;
import com.efashionshop.model.CartItem;
import com.efashionshop.model.User;
import com.efashionshop.response.ApiResponse;
import com.efashionshop.service.CartItemService;
import com.efashionshop.service.CartService;
import com.efashionshop.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private UserService userService;
	
	@DeleteMapping("/{cartItemId}")
	public ResponseEntity<ApiResponse>deleteCartItem(@PathVariable Long cartItemId,
			@RequestHeader("Authorization")String jwt)throws UserException,CartItemException{
		
		User user=userService.findUserProfileByJwt(jwt);
		cartItemService.removeCartItem(user.getId(), cartItemId);
		
		ApiResponse res=new ApiResponse();
		res.setMessage("delete item from cart");
		res.setStatus(true);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@PutMapping("/{cartItemId}")
	public ResponseEntity<CartItem>updateCartItem(@RequestBody CartItem cartItem,
			@PathVariable Long cartItemId,
			@RequestHeader("Authorization")String jwt)throws UserException,CartItemException{
		
		User user=userService.findUserProfileByJwt(jwt);
		
		CartItem updateCartItem=cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);
		
		return new ResponseEntity<>(updateCartItem,HttpStatus.OK);
	}
	
	

}
