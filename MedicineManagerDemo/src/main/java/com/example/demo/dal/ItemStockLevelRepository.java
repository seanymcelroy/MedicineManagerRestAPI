package com.example.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ItemStockLevel;
import com.example.demo.model.Prescription;
import com.example.demo.model.PrescriptionLineItem;
import com.example.demo.model.user.Patient;
import com.example.demo.model.user.Pharmacy;

public interface ItemStockLevelRepository extends JpaRepository<ItemStockLevel, Integer>{

//	List<ItemStockLevel> findAllByItemStockMedicine(int qty);
	
	List<ItemStockLevel> findAllByItemStockPharmacy(Pharmacy p);
}
