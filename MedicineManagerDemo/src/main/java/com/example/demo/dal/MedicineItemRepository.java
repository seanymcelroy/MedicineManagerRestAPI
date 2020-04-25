package com.example.demo.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MedicineItem;

public interface MedicineItemRepository  extends JpaRepository<MedicineItem, Integer>{

	MedicineItem findMedicineItemByBarcode(String barcode);
	
	//FindByGenname
	
}
