package com.rcontrol.api.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rcontrol.api.model.Product;
import com.rcontrol.api.repository.ProductRepository;
import com.rcontrol.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product update(Long id, Product product) {
		
		Product productSaved = productRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(product, productSaved, "id");
		
		return productRepository.save(productSaved);
	}

}
