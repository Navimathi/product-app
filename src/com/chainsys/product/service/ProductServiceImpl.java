package com.chainsys.product.service;

import java.util.List;
import java.util.Set;

import com.chainsys.product.dao.ProductDAO;
import com.chainsys.product.dao.ProductDAOImpl;
import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;

public class ProductServiceImpl implements ProductService {
	private static ProductDAO dao;

	public ProductServiceImpl() {
		dao = new ProductDAOImpl();
	}

	@Override
	public Set<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product findById(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			return Product;
		}
	}

	@Override
	public void save(Product Product) {
		dao.save(Product);

	}

	@Override
	public void update(Product Product) throws ProductNotFoundException {
		Product result = dao.findById(Product.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.update(Product);
		}

	}

	@Override
	public void delete(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(id);
		}
	}
	
	@Override
	public Product findbyname(String name) throws ProductNotFoundException {
		Product Product = dao.findbyname(name);
		if (Product == null) {
			throw new ProductNotFoundException("Product Name Not Found");
		} else {
			return Product;
		}
	}
	
	@Override
	public void updateExpire(Product Product) throws ProductNotFoundException {
		Product result = dao.findById(Product.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.updateExpire(Product);
		}
	}
	@Override
	public void deletebyname(String name) throws ProductNotFoundException {
		Product Product = dao.findbyname(name);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.deletebyname(name);
		}
	}
	@Override
	public List<String> ViewAllProductName(){
		return dao.ViewAllProductName();
	}
	
	@Override
	public Product findByDate (String date) throws ProductNotFoundException {
		Product productED = dao.findByDate(date);
		if(productED == null) {
			throw new ProductNotFoundException("Product doesn't exist");
		}
		else {
			return productED;
		}
	}
	
	@Override
	public void deleteByExpiryDate (String date) throws ProductNotFoundException {
		Product productED = dao.findByDate(date);
		if(productED == null) {
			throw new ProductNotFoundException("Product doesn't exist");
		}
		else {
			dao.deleteByExpiryDate(date);
		}
	}
	
	

}
