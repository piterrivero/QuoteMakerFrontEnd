package com.quotemaker.frontend.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Product {

	private long idProduct;
	
	@NotEmpty(message="Please enter the name")
	private String name;

	@Pattern(regexp="^\\d+(,\\d{3})*(\\.\\d{1,2})?$", message="Please enter a valid price")
	private String price;
	
	public Product() {
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
