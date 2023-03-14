package com.training.spring.BamboosBuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.spring.BamboosBuy.model.Sports;


public interface SportsRepository extends JpaRepository<Sports, String> {

}
