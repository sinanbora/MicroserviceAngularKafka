package com.programming.techie.productservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programming.techie.productservice.dto.ProductRequest;
import com.programming.techie.productservice.model.Product;
import com.programming.techie.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository productRepository = null;
	
	public Product createProduct(ProductRequest productRequest){
		Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
		log.info("Product created successfully");
		
		return product;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
		
	}
}
