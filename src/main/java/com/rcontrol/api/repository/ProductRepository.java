package com.rcontrol.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcontrol.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
