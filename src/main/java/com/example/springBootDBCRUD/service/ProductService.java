package com.example.springBootDBCRUD.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springBootDBCRUD.model.Product;
import com.example.springBootDBCRUD.model.ProductCategoryDto;
import com.example.springBootDBCRUD.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);

		return products;

	}

	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);

	}

	public void addProduct(Product product) {

		productRepository.save(product);

	}

	public void updateProduct(Long id, Product product) {
		if (productRepository.findById(id).get() != null) {
			productRepository.save(product);

		}
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);

	}
//
//	public List<Product> getProductByName() {
//		// TODO Auto-generated method stub
//		return productRepository.;
//	}

	public List<Product> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(category);
	}

	public List<Product> getProductByNameAndCategory(String name, String category) {
		// TODO Auto-generated method stub
		return productRepository.findByNameOrCategory(name, category);
	}

	public List<Product> getProductByNameAndCategoryContaining(String name, String category) {
		// TODO Auto-generated method stub
		return productRepository.findByNameContainsOrCategoryContains(name, category);
	}

	public List<Product> getByHqlQuery(String name, String category) {
		// TODO Auto-generated method stub
		return productRepository.getByHqlQuery(name, category);
	}

	public List<Product> getBySqlQuery(String name, String category) {
		// TODO Auto-generated method stub
		return productRepository.getBySqlQuery(name, category);
	}

	public List<Product> getByPagenation(String name, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable= PageRequest.of(pageNumber, pageSize);
		return productRepository.findByNameContains(name,pageable);
	}

	public List<ProductCategoryDto> categoryCount() {
		// TODO Auto-generated method stub
		return productRepository.categoryCount();
	}

}
