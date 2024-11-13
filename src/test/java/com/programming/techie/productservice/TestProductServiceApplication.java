package com.programming.techie.productservice;

import org.springframework.boot.SpringApplication;

import com.programming.techie.productservice.ProductServiceApplication;

public class TestProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
