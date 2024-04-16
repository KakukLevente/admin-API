package com.efashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.efashionshop.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{
	
	@Query("SELECT c From Cart c Where c.user.id=:userId")
	public Cart findByUserId(@Param("userId")Long userId);

}
