package com.example.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MedicineItem;
import com.example.demo.model.Prescription;
import com.example.demo.model.PrescriptionLineItem;

public interface PrescriptionLineItemRepository extends JpaRepository<PrescriptionLineItem, Integer>{

	
	//Find list of prescriptions by line item
	List<PrescriptionLineItem> findAllByprescriptionLineItemPrescription(Prescription prescription);
	List<PrescriptionLineItem> findAllByprescriptionLineItemPrescriptionPrescriptionID(int prescriptionId);
//	List<PrescriptionLineItem> findPrescriptionLineItemsByPrescriptionPrescriptionID(int prescriptionId);


	//Find list of lineItems by MedicineItem
	List<PrescriptionLineItem> findAllByLineItemMedicineMedicineItemID(int medicineItem);

}
