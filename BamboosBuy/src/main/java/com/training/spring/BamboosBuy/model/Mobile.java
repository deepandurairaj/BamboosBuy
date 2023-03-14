package com.training.spring.BamboosBuy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Mobile 
{
	@Id
	@Column(name="brand_name")
	private String brandname;
	@Column(name="model")
	private String model;
	@Column(name="price")
	private double price;
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Mobile(String brandname, String model, double price) {
		super();
		this.brandname = brandname;
		this.model = model;
		this.price = price;
	}
	public Mobile() {
		super();
	}
	
	

}
