package com.training.spring.BamboosBuy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.BamboosBuy.model.Sports;
import com.training.spring.BamboosBuy.model.SportsNotFoundException;
import com.training.spring.BamboosBuy.repository.SportsRepository;


@Service
public class SportsService 
{
	@Autowired
	SportsRepository sportsrepository;

	public List<Sports> getSports() 
	{
		List<Sports> sport = sportsrepository.findAll();
		
		if(sport.size()>0)
		{
			return sport;
		}
		else
		{
			return new ArrayList<Sports>();
		}
	}

	public Sports getSportsByBrand(String brandname) throws SportsNotFoundException
	{
		Optional<Sports> sports = sportsrepository.findById(brandname);
		
		if(sports.isPresent())
		{
			return sports.get();
		}
		else
		{
			throw new SportsNotFoundException("Brand Not Available");
		}
	}

	public Sports createorUpdate(Sports sports) throws SportsNotFoundException
	{
		Optional<Sports> sport= sportsrepository.findById(sports.getBrandname());
		
		if(sport.isPresent())
		{
			Sports newSports= sport.get();
			newSports.setBrandname("MRF");
			newSports.setProductname("CricketBat");
			newSports.setPrice(2500);
			
			newSports= sportsrepository.save(newSports);
			return newSports;
		}
		else
		{
			sports = sportsrepository.save(sports);
			return sports;
		}
	}

	public void deleteSportsByBrand(String brandname) throws SportsNotFoundException
	{
		Optional<Sports> sports = sportsrepository.findById(brandname);
		
		if(sports.isPresent())
		{
			sportsrepository.deleteById(brandname);
		}
		else
		{
			throw new SportsNotFoundException("Brand not found");
		}
	}

}
