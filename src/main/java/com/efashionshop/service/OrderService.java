package com.efashionshop.service;

import java.util.List;

import com.efashionshop.exception.OrderException;
import com.efashionshop.model.Address;
import com.efashionshop.model.Order;
import com.efashionshop.model.User;

public interface OrderService {
	
	
	public Order createOrder(User user, Address shippingAddress);
	
		public Order findOrderById(Long orderId) throws OrderException;
		
		
		
		public Order placedOrder(Long orderId) throws OrderException;
		
		public Order confirmedOrder(Long orderId) throws OrderException;
		
		public Order shippedOrder(Long orderId) throws OrderException;
		
		public Order deliveredOrder(Long orderId) throws OrderException;
		
		public Order canceledOrder(Long orderId) throws OrderException;
		
		public List<Order>getAllOrders();
		
		public void deleteOrder(Long orderId) throws OrderException;

		List<Order> usersOrderHistory(Long userId);

}
