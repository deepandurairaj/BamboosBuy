package com.training.spring.BamboosBuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.spring.BamboosBuy.model.Electronics;


public interface ElectronicsRepository extends JpaRepository<Electronics, String> {

}
