package com.training.spring.BamboosBuy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.BamboosBuy.model.Category;
import com.training.spring.BamboosBuy.model.CategoryNotFoundException;
import com.training.spring.BamboosBuy.repository.CategoryRepository;

@Service
public class CategoryService 
{
	@Autowired
	CategoryRepository categoryrepository;
	
	public List<Category> getCategory()
	{
		List<Category> category = categoryrepository.findAll();
		
		if(category.size()>0)
		{
			return category;
		}
		else
		{
			return new ArrayList<Category>();
		}
	}
	
	
	
	public Category createorUpdateProduct(Category category) throws CategoryNotFoundException
	{
		Optional<Category> categories = categoryrepository.findById(category.getCategoryname());
		
		if(categories.isPresent())
		{
			Category newCategory = categories.get();
			newCategory.setCategoryname(category.getCategoryname());
			
			newCategory = categoryrepository.save(category);
			return newCategory;
			
		}
		else
		{
			category= categoryrepository.save(category);
			return category;
		}
	}
	public void deleteCategory(String category) throws CategoryNotFoundException
	{
		Optional<Category> categories = categoryrepository.findById(category);
		
		if(categories.isPresent())
		{
			categoryrepository.deleteById(category);
		}
		else
		{
			throw new CategoryNotFoundException("Category  Not Found");
		}
	}
}
