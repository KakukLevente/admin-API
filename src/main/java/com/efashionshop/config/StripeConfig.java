package com.efashionshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.stripe.Stripe;

import jakarta.annotation.PostConstruct;

@Configuration
public class StripeConfig {
	
	@Value("${stripe.api.secretKey}")
	private String secretKey;
	
	@PostConstruct
	public void initSecretKey(){
		Stripe.apiKey=secretKey;
	}

}
