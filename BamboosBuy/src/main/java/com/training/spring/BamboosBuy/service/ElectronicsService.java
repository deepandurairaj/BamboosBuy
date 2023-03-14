package com.training.spring.BamboosBuy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.BamboosBuy.model.Electronics;
import com.training.spring.BamboosBuy.model.ElectronicsNotFoundException;
import com.training.spring.BamboosBuy.repository.ElectronicsRepository;

@Service
public class ElectronicsService 
{
	@Autowired
	ElectronicsRepository electronicsrepository;

	public List<Electronics> getElectronics() 
	{
		List<Electronics> electronics = electronicsrepository.findAll();
		
		if(electronics.size()>0)
		{
			return electronics;
		}
		else
		{
			return new ArrayList<Electronics>();
		}
	}

	public Electronics getElectronicsByBrand(String brandname) throws ElectronicsNotFoundException
	{
		Optional<Electronics> electronic = electronicsrepository.findById(brandname);
		
		if(electronic.isPresent())
		{
			return electronic.get();
		}
		else
		{
			throw new ElectronicsNotFoundException("Brand Not Available");
		}
	}

	public Electronics createorUpdate(Electronics electronics) throws ElectronicsNotFoundException
	{
		Optional<Electronics> electron= electronicsrepository.findById(electronics.getBrandname());
		
		if(electron.isPresent())
		{
			Electronics newElectronics= electron.get();
			newElectronics.setBrandname("LG");
			newElectronics.setProductname("Television");
			newElectronics.setPrice(29999);
			
			newElectronics= electronicsrepository.save(newElectronics);
			return newElectronics;
		}
		else
		{
			electronics = electronicsrepository.save(electronics);
			return electronics;
		}
	}

	public void deleteElectronicsByBrand(String brandname) throws ElectronicsNotFoundException
	{
		Optional<Electronics> electronics = electronicsrepository.findById(brandname);
		
		if(electronics.isPresent())
		{
			electronicsrepository.deleteById(brandname);
		}
		else
		{
			throw new ElectronicsNotFoundException("Brand not found");
		}
	}

}
