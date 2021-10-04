package com.example.springBootDBCRUD.model;

public class ProductCategoryDto {
	private String category;
	private Long count ;
	public ProductCategoryDto(String category, Long count) {
		super();
		this.category = category;
		this.count = count;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public ProductCategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
