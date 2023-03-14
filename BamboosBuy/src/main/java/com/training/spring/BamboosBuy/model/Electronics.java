package com.training.spring.BamboosBuy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Electronics 
{
	@Id
	@Column(name="brand_name")
	private String brandname;
	@Column(name="product_name")
	private String productname;
	@Column(name="price")
	private double price;
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Electronics(String brandname, String productname, double price) {
		super();
		this.brandname = brandname;
		this.productname = productname;
		this.price = price;
	}
	public Electronics() {
		super();
	}
	
	
	
}
