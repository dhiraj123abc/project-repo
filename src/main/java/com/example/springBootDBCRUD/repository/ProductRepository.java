package com.example.springBootDBCRUD.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springBootDBCRUD.model.Product;
import com.example.springBootDBCRUD.model.ProductCategoryDto;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategory(String category);

	@Query("from Product where name= :name and category= :category")
	List<Product> getByHqlQuery(String name, String category);

	@Query(value = "select p.* from product p where p.name= :name and p.category= :category", nativeQuery = true)
	List<Product> getBySqlQuery(String name, String category);

	List<Product> findByNameOrCategory(String name, String category);

	List<Product> findByNameContainsOrCategoryContains(String name, String category);

	List<Product> findByNameContains(String name, Pageable pageable);

	@Query("select new com.example.springBootDBCRUD.model.ProductCategoryDto(category,count(*)) from Product group by category")
	List<ProductCategoryDto> categoryCount();

}
