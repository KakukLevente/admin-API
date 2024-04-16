package com.efashionshop.service;

import java.util.List;

import com.efashionshop.exception.ProductException;
import com.efashionshop.model.Review;
import com.efashionshop.model.User;
import com.efashionshop.request.ReviewRequest;

public interface ReviewService {
	
	public Review createReview(ReviewRequest req, User user)throws ProductException;
	public List<Review>getAllReview(Long productId);

}
