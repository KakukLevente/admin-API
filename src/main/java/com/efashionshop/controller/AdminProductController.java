package com.efashionshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.efashionshop.exception.ProductException;
import com.efashionshop.model.Product;
import com.efashionshop.request.CreateProductRequest;
import com.efashionshop.response.ApiResponse;
import com.efashionshop.service.ProductService;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<Product>createProduct(@RequestHeader("Authorization")String jwt, @RequestBody CreateProductRequest req){
		
		Product product=productService.createProduct(req);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{productId}/delete")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) throws ProductException{
		
		productService.deleteProduct(productId);
		ApiResponse res=new ApiResponse();
		res.setMessage("product deleted successfully");
		res.setStatus(true);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProduct() {
		
	    List<Product> products = productService.findAllProducts();
	    
	    return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product>updateProduct(@RequestBody Product req,@PathVariable Long id)throws ProductException{

		Product product=productService.updateProduct(id, req);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/creates")
	public ResponseEntity<ApiResponse>createMultipleProduct(@RequestBody CreateProductRequest[]req){
		
		for(CreateProductRequest product:req) {
			productService.createProduct(product);
		}
		ApiResponse res=new ApiResponse();
		res.setMessage("product created successfully");
		res.setStatus(true);
		
		return new ResponseEntity<>(res,HttpStatus.CREATED);
	}

}
