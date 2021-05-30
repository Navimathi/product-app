package com.chainsys.product.dao;

import java.util.List;
import java.util.Set;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();

	Product findById(int id);

	void save(Product product);

	void update(Product product);

	public List<String> ViewAllProductName();
	
	void deletebyname(String name);
	
	void delete(int id);
	
	Product findbyname(String name);
	
	void updateExpire(Product product);
	
	Product findByDate (String date);
	
	void deleteByExpiryDate (String date);
}
