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

import com.training.spring.BamboosBuy.model.Electronics;
import com.training.spring.BamboosBuy.model.ElectronicsNotFoundException;
import com.training.spring.BamboosBuy.service.ElectronicsService;
@RestController
@RequestMapping("/Electronics/")
public class ElectronicsController 
{
	@Autowired
	ElectronicsService electronicsservice;
	
	@GetMapping
	public ResponseEntity<List<Electronics>> getElectronics()
	{
		List<Electronics> list = electronicsservice.getElectronics();
		return new ResponseEntity<List<Electronics>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/{brand}")
	public ResponseEntity<Electronics> getElectronicsByBrand(@PathVariable("brand") String brandname) throws ElectronicsNotFoundException
	{
		Electronics entity = electronicsservice.getElectronicsByBrand(brandname);
		return new ResponseEntity<Electronics>(entity, new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Electronics> createorUpdate(@RequestBody Electronics electronics) throws ElectronicsNotFoundException
	{
		Electronics updated = electronicsservice.createorUpdate(electronics);
		return new ResponseEntity<Electronics>(updated,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{brand}")
	public HttpStatus deleteElectronicsByBrand(@PathVariable("brand") String brandname) throws ElectronicsNotFoundException
	{
		electronicsservice.deleteElectronicsByBrand(brandname);
		return HttpStatus.OK;
	}
	
}
