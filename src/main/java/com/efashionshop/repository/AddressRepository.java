package com.efashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efashionshop.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
