package com.chainsys.product.dao;

import java.util.Set;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();

	Product findById(int id);

	void save(Product product);

	void update(Product product);

	void deletebyname(String name);
	
	void delete(int id);
	
	Product findbyname(String name);
	
	void updateExpire(Product product);
}
