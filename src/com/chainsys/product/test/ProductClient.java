package com.chainsys.product.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;
import com.chainsys.product.service.ProductServiceImpl;

public class ProductClient {
	public static void main(String[] args) {

		Set<Product> productSet;
		ProductService service = new ProductServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		String name;
		List<String> namelist;
		List<Integer> idlist;
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 2:
			System.out.println("Find the Product By Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				Product product = service.findById(id);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 3:
			System.out.println("Update the Product Name Based on the Id");
			date = "05/30/2021";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct = new Product(3, "Milk", LocalDate.parse(date, dateFormat));
			try {
				service.update(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		case 4:
			System.out.println("Adding a Product");
			date = "05/30/2021";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product newProduct = new Product(3, "Milk", LocalDate.parse(date, dateFormat));
			service.save(newProduct);
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 5:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				service.delete(id);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
		case 6:
			System.out.println("Find the Product by Name");
			System.out.println("Enter the Product Name");
			name=scanner.next();
			try {
				Product product=service.findbyname(name);
				System.out.println(product);
			}catch (ProductNotFoundException e) {
			}
		case 7:
			System.out.println("Update the expiry date based on id");
			System.out.println("Enter the id for which the expiry is to be updated");
			id=scanner.nextInt();
			date = "05/29/2021";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updatedate = new Product(id, "Milk", LocalDate.parse(date, dateFormat));
			try {
				service.updateExpire(updatedate);
				productSet =service.findAll();
				System.out.println(productSet);
			}catch(ProductNotFoundException e){
			}
		case 8:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Name");
			name = scanner.next();
			try {
				service.deletebyname(name);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
		case 9:
			System.out.println("View All Product Name");
			namelist=service.ViewAllProductName();
			System.out.println(namelist);
			break;
		case 10:
			System.out.println("Find the Product by Expiry Date");
			System.out.println("Enter the Expiry Date");
			date = scanner.next();
			try {
				Product productED = service.findByDate(date);
				System.out.println(productED);
			}catch(ProductNotFoundException e){
			}
		case 11:
			System.out.println("Deleting the Product by Expiry Date");
			System.out.println("Enter the Product Expiry Date");
			date = scanner.next();
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			try{
				service.deleteByExpiryDate(date);
				Product productED = service.findByDate(date);
				System.out.println(productED);
			}catch(ProductNotFoundException e) {
			}
			break;
		case 12:
			System.out.println("View all product IDs");
			idlist = service.viewAllProductId();
			System.out.println(idlist);
			break;
			
			default:
			break;
		}
		scanner.close();
	}

}
