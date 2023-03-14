package com.training.spring.BamboosBuy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category 
{
	@Id
	@Column(name="category_name")
	private String categoryname;

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Category(String categoryname) {
		super();
		this.categoryname = categoryname;
	}

	public Category() {
		super();
	}
	
	
	
}
