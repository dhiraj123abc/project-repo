package com.example.springBootDBCRUD.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootDBCRUD.model.Product;
import com.example.springBootDBCRUD.model.ProductCategoryDto;
import com.example.springBootDBCRUD.service.ProductService;

@RestController
public class ProductController {
	public static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		logger.debug("==============> into the getProduct method ");
		return productService.getAllProducts();

	}

	@GetMapping("/products/categorycount")
	public List<ProductCategoryDto> categoryCount() {
		return productService.categoryCount();

	}

	@GetMapping("/products/category")
	public List<Product> getProductByCategory(@RequestParam String category) {
		return productService.getProductByCategory(category);

	}

	@GetMapping("/products/Hqlquery")
	public List<Product> getByHqlQuery(@RequestParam String name, @RequestParam String category) {
		return productService.getByHqlQuery(name, category);

	}

	@GetMapping("/products/Sqlquery")
	public List<Product> getBySqlQuery(@RequestParam String name, @RequestParam String category) {
		return productService.getBySqlQuery(name, category);

	}

	@GetMapping("/products/nameandcategory")
	public List<Product> getProductByNameAndCategory(@RequestParam String name, @RequestParam String category) {
		return productService.getProductByNameAndCategory(name, category);

	}

	@GetMapping("/products/contains")
	public List<Product> getProductByNameAndCategoryContaining(@RequestParam String name,
			@RequestParam String category) {
		return productService.getProductByNameAndCategoryContaining(name, category);

	}

	@GetMapping("/products/pagenation")
	public List<Product> getByPagenation(@RequestParam String name, @RequestParam int pageNumber,
			@RequestParam int pageSize) {
		return productService.getByPagenation(name, pageNumber, pageSize);

	}

	@GetMapping("/products/{pid}")
	public Optional<Product> getProductById(@PathVariable("pid") Long id) {
		return productService.getProductById(id);

	}

	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);

	}

	@PutMapping("/products/{pid}")
	public void updateProduct(@PathVariable("pid") Long id, @RequestBody Product product) {
		productService.updateProduct(id, product);

	}

	@DeleteMapping("/products/{pid}")
	public void deleteProduct(@PathVariable("pid") Long id) {
		productService.deleteProduct(id);

	}
}
