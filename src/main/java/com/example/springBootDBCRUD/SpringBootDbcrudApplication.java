package com.example.springBootDBCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springBootDBCRUD.model.Product;
import com.example.springBootDBCRUD.repository.ProductRepository;

@SpringBootApplication
public class SpringBootDbcrudApplication {
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDbcrudApplication.class, args);

	}

}
