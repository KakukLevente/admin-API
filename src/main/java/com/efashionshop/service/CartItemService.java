package com.efashionshop.service;

import com.efashionshop.exception.CartItemException;
import com.efashionshop.exception.UserException;
import com.efashionshop.model.Cart;
import com.efashionshop.model.CartItem;
import com.efashionshop.model.Product;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId,Long id, CartItem cartItem)throws CartItemException, UserException;
	
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);
	
	public void removeCartItem(Long userId, Long cartItemId)throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId)throws CartItemException;

}
