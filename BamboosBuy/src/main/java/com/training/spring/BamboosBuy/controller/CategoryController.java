package com.training.spring.BamboosBuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.BamboosBuy.model.Category;
import com.training.spring.BamboosBuy.model.CategoryNotFoundException;
import com.training.spring.BamboosBuy.service.CategoryService;

@RestController
@RequestMapping("/Category/")
public class CategoryController 
{
	@Autowired
	CategoryService categoryservice;
	
	@GetMapping
	public ResponseEntity<List<Category>> getCategory()
	{
		List<Category> list = categoryservice.getCategory();
		return new ResponseEntity<List<Category>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Category> createorUpdateProduct(@RequestBody Category category) throws CategoryNotFoundException
	{
		Category updated= categoryservice.createorUpdateProduct(category);
		return new ResponseEntity<Category>(updated,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{category}")
	public HttpStatus deleteCategory(@PathVariable("category") String category) throws CategoryNotFoundException
	{
		categoryservice.deleteCategory(category);
		return HttpStatus.OK;
	}
}
