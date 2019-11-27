package com.example.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy, String>{
	
	List<Pharmacy> findByPharmacyName(String pharmacyName);

}
