package com.cybersoft.java14.jstl.service;

import java.util.ArrayList;
import java.util.List;

import com.cybersoft.java14.jstl.model.Product;
import com.cybersoft.java14.jstl.reposiroty.Repository;

public class ProductService {
	private List<Product> products;
	private Repository reposetory;
	public ProductService() {
		reposetory = new Repository();
	}
	
	// add product
	public boolean addProduct(Product product) {
		return reposetory.addProduct(product) == 1 ? true : false;
	}
	
	// delete product
	public boolean removeProduct(String productId) {
		return reposetory.removeProduct(productId) == 1 ? true : false;
	}
	
	// get products
	public List<Product> getProducts() {
		return reposetory.getProducts();
	}
	
}
