package com.efashionshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.efashionshop.exception.ProductException;
import com.efashionshop.model.Rating;
import com.efashionshop.model.User;
import com.efashionshop.request.RatingRequest;


public interface RatingService {
	
	public Rating createRating(RatingRequest req, User user)throws ProductException;
	public List<Rating>getProductsRating(Long productId);

}
