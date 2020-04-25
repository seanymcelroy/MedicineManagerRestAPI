package com.example.demo.dal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.user.Pharmacy;


public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {
	
	boolean existsPharmacyByPharmacyName(String farmName);
	
	boolean existsPharmacyByPharmacyEmail(String pharmacyEmail);
	
	boolean existsPharmacyByPsiRegistrationNumber(String psiNum);
	
	
	Pharmacy findByPharmacyName(String pharmacyName);
	
}
