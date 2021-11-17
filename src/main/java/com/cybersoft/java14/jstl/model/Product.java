package com.cybersoft.java14.jstl.model;

public class Product {
	private String ID;
	private String name;
	private String description;
	private float price;
	private int stock;

	public Product(String iD, String name, String desciption, float price, int stock) {
		ID = iD;
		this.name = name;
		this.description = desciption;
		this.price = price;
		this.stock = stock;
	}
	/* Getters/ Setters */

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desciption) {
		this.description = desciption;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
