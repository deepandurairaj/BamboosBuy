package com.training.spring.BamboosBuy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.BamboosBuy.model.ElectronicsNotFoundException;
import com.training.spring.BamboosBuy.model.Mobile;
import com.training.spring.BamboosBuy.model.MobileNotFoundException;
import com.training.spring.BamboosBuy.repository.MobileRepository;

@Service
public class MobileService 
{
	@Autowired
	MobileRepository mobilerepository;
	
	public List<Mobile> getMobile() 
	{
		List<Mobile> mobile = mobilerepository.findAll();
		
		if(mobile.size()>0)
		{
			return mobile;
		}
		else
		{
			return new ArrayList<Mobile>();
		}
	}

	public Mobile getMobileByBrand(String brandname) throws MobileNotFoundException
	{
		Optional<Mobile> mobiles = mobilerepository.findById(brandname);
		
		if(mobiles.isPresent())
		{
			return mobiles.get();
		}
		else
		{
			throw new ElectronicsNotFoundException("Brand Not Available");
		}
	}

	public Mobile createorUpdate(Mobile mobile) throws MobileNotFoundException
	{
		Optional<Mobile> mobiles= mobilerepository.findById(mobile.getBrandname());
		
		if(mobiles.isPresent())
		{
			Mobile newMobile= mobiles.get();
			newMobile.setBrandname("Apple");
			newMobile.setModel("Iphone11");
			newMobile.setPrice(38000);
			
			newMobile= mobilerepository.save(newMobile);
			return newMobile;
		}
		else
		{
			mobile = mobilerepository.save(mobile);
			return mobile;
		}
	}

	public void deleteMobileByBrand(String brandname) throws MobileNotFoundException
	{
		Optional<Mobile> mobile = mobilerepository.findById(brandname);
		
		if(mobile.isPresent())
		{
			mobilerepository.deleteById(brandname);
		}
		else
		{
			throw new MobileNotFoundException("Brand not found");
		}
	}

}
