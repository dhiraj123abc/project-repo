package com.example.springBootDBCRUD.exception;

public class ProductNotFoundException extends RuntimeException{
	private static final Long serialVersionUID= 1L;
	
	public ProductNotFoundException(Long id ) {
		super("product with this ID  "+id+" is not found in DB");
		
	}

}
