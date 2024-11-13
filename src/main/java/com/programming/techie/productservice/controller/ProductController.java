package com.programming.techie.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.productservice.dto.ProductRequest;
import com.programming.techie.productservice.model.Product;
import com.programming.techie.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService=null;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody ProductRequest productRequest) {
		return productService.createProduct(productRequest);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Product getAllProducts() {
		return productService.getAllProducts();
	}

}
