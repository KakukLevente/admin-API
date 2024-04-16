package com.efashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efashionshop.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{

}
