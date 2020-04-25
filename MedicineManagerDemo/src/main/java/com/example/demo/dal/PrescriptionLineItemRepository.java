package com.example.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Prescription;
import com.example.demo.model.PrescriptionLineItem;

public interface PrescriptionLineItemRepository extends JpaRepository<PrescriptionLineItem, Integer>{

	
	//Find list of prescriptions by patient
//	List<PrescriptionLineItem> findPrescriptionLineItemsByPrescription(Prescription prescription);
//	List<PrescriptionLineItem> findPrescriptionLineItemsByPrescriptionPrescriptionID(int prescriptionId);
}
