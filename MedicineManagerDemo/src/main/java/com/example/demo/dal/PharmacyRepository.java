package com.example.demo.dal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.user.Pharmacy;


public interface PharmacyRepository extends JpaRepository<Pharmacy, String> {
	
	boolean existsPharmacyByPharmacyName(String farmName);
	
	boolean existsPharmacyBypsiRegistrationNumber(String psiNum);
	
}
