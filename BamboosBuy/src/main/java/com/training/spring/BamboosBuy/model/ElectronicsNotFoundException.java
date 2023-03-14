package com.training.spring.BamboosBuy.model;

@SuppressWarnings("serial")
public class ElectronicsNotFoundException  extends RuntimeException
{
	public ElectronicsNotFoundException(String exception)
	{
		super(exception);
	}
	
	public ElectronicsNotFoundException(String exception, Throwable t)
	{
		super(exception,t);
	}

}
