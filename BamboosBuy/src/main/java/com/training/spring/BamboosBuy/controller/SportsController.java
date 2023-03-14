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

import com.training.spring.BamboosBuy.model.Sports;
import com.training.spring.BamboosBuy.model.SportsNotFoundException;
import com.training.spring.BamboosBuy.service.SportsService;

@RestController
@RequestMapping("/Sports/")
public class SportsController 
{
	@Autowired
	SportsService sportsservice;
	
	@GetMapping
	public ResponseEntity<List<Sports>> getSports()
	{
		List<Sports> list = sportsservice.getSports();
		return new ResponseEntity<List<Sports>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/{brand}")
	public ResponseEntity<Sports> getSportsByBrand(@PathVariable("brand") String brandname) throws SportsNotFoundException
	{
		Sports entity = sportsservice.getSportsByBrand(brandname);
		return new ResponseEntity<Sports>(entity, new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Sports> createorUpdate(@RequestBody Sports sports) throws SportsNotFoundException
	{
		Sports updated = sportsservice.createorUpdate(sports);
		return new ResponseEntity<Sports>(updated,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{brand}")
	public HttpStatus deleteSportsByBrand(@PathVariable("brand") String brandname) throws SportsNotFoundException
	{
		sportsservice.deleteSportsByBrand(brandname);
		return HttpStatus.OK;
	}
	
}
