package com.efashionshop.service;

import com.efashionshop.exception.ProductException;
import com.efashionshop.model.Cart;
import com.efashionshop.model.CartItem;
import com.efashionshop.model.User;
import com.efashionshop.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public CartItem addCartItem(Long userId, AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);



}
