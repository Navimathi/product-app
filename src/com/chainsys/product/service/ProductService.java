package com.chainsys.product.service;

import java.util.List;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;

public interface ProductService {
	Set<Product> findAll();

	public List<String> ViewAllProductName();
	
	public List<Integer> viewAllProductId();
	
	Product findById(int id) throws ProductNotFoundException;

	void updateExpire(Product Product) throws ProductNotFoundException;
	
	void save(Product Product);

	void update(Product Product) throws ProductNotFoundException;

	void delete(int id) throws ProductNotFoundException;

	void deletebyname(String name) throws ProductNotFoundException;
	
	Product findbyname(String name) throws ProductNotFoundException;
	
	Product findByDate(String date) throws ProductNotFoundException;
	
	void deleteByExpiryDate(String date) throws ProductNotFoundException;

}
