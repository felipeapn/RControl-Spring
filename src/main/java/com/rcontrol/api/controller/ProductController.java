package com.rcontrol.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rcontrol.api.model.Product;
import com.rcontrol.api.repository.ProductRepository;
import com.rcontrol.api.service.ProductService;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "http://192.168.0.12:4200")
//TODO: Configurar CORS global. Tutorial - https://www.tutorialspoint.com/spring_boot/spring_boot_cors_support.htm.	


public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<Product> create(@Valid @RequestBody Product product, HttpServletResponse response) {
		Product productSaved = productRepository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
		
		Product productSaved = productService.update(id, product);
		
		return ResponseEntity.ok(productSaved);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productRepository.deleteById(id);
	}
}
