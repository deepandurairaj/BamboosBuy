package com.training.spring.BamboosBuy.model;

@SuppressWarnings("serial")
public class SportsNotFoundException extends RuntimeException
{
	public SportsNotFoundException(String exception)
	{
		super(exception);
	}
	
	public SportsNotFoundException(String exception, Throwable t)
	{
		super(exception,t);
	}

}
