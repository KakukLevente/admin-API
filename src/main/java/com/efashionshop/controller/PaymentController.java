/*package com.efashionshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efashionshop.exception.OrderException;
import com.efashionshop.exception.UserException;
import com.efashionshop.model.Order;
import com.efashionshop.repository.OrderRepository;
import com.efashionshop.service.OrderService;
import com.efashionshop.service.UserService;


@RestController
@RequestMapping("/api")
public class PaymentController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderRepository orderRepository;
	
	
	@PostMapping("/payments/{orderId}")
	public ResponseEntity<PaymentLinkResponse>createPaymentLink(
			@PathVariable Long orderId,
			@RequestHeader("Authorization")String jwt)throws StripeException, UserException, OrderException{
		
		Order order=orderService.findOrderById(orderId);
		
		try {
			
			StripeClient razorpay=new StripeClient(
					"key",
					"merche");
			
		}catch (Exception e){}
		
		
		
		return null;
		
	}

}*/
