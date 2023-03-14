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

import com.training.spring.BamboosBuy.model.Mobile;
import com.training.spring.BamboosBuy.model.MobileNotFoundException;
import com.training.spring.BamboosBuy.service.MobileService;


@RestController
@RequestMapping("/Mobile/")
public class MobileController 
{
	@Autowired
	MobileService mobileservice;
	
	@GetMapping
	public ResponseEntity<List<Mobile>> getMobile()
	{
		List<Mobile> list = mobileservice.getMobile();
		return new ResponseEntity<List<Mobile>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/{brand}")
	public ResponseEntity<Mobile> getMobileByBrand(@PathVariable("brand") String brandname) throws MobileNotFoundException
	{
		Mobile entity = mobileservice.getMobileByBrand(brandname);
		return new ResponseEntity<Mobile>(entity, new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Mobile> createorUpdate(@RequestBody Mobile mobile) throws MobileNotFoundException
	{
		Mobile updated = mobileservice.createorUpdate(mobile);
		return new ResponseEntity<Mobile>(updated,new HttpHeaders(),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{brand}")
	public HttpStatus deleteMobileByBrand(@PathVariable("brand") String brandname) throws MobileNotFoundException
	{
		mobileservice.deleteMobileByBrand(brandname);
		return HttpStatus.OK;
	}
	
}
