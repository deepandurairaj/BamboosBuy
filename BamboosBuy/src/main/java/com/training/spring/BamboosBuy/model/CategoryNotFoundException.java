package com.training.spring.BamboosBuy.model;

@SuppressWarnings("serial")
public class CategoryNotFoundException extends RuntimeException
{
	public CategoryNotFoundException(String exception)
	{
		super(exception);
	}
	
	public CategoryNotFoundException(String exception, Throwable t)
	{
		super(exception,t);
	}
}


