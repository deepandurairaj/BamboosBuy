package com.training.spring.BamboosBuy.model;

@SuppressWarnings("serial")
public class MobileNotFoundException  extends RuntimeException
{
	public MobileNotFoundException(String exception)
	{
		super(exception);
	}
	
	public MobileNotFoundException(String exception, Throwable t)
	{
		super(exception,t);
	}

}
