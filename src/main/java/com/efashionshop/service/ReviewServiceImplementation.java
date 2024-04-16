package com.efashionshop.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.efashionshop.exception.ProductException;
import com.efashionshop.model.Product;
import com.efashionshop.model.Review;
import com.efashionshop.model.User;
import com.efashionshop.repository.ProductRepository;
import com.efashionshop.repository.ReviewRepository;
import com.efashionshop.request.ReviewRequest;

@Service
public class ReviewServiceImplementation implements ReviewService{
	
	private ReviewRepository reviewRepository;
	private ProductService productService;
	private ProductRepository productRepository;
	
	public ReviewServiceImplementation(ReviewRepository reviewRepository,
			ProductService productService,
			ProductRepository productRepository) {
		this.reviewRepository=reviewRepository;
		this.productService=productService;
		
	}
	

	@Override
	public Review createReview(ReviewRequest req, User user) throws ProductException {
		Product product=productService.findProductById(req.getProductId());
		
		Review review=new Review();
		review.setUser(user);
		review.setProduct(product);
		review.setReview(req.getReview());
		review.setCreatedAt(LocalDateTime.now());
		
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReview(Long productId) {
		// TODO Auto-generated method stub
		return reviewRepository.getAllProductsReview(productId);
	}

}
