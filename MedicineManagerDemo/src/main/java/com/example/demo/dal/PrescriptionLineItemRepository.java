package com.example.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.MedicineItem;
import com.example.demo.model.Prescription;
import com.example.demo.model.PrescriptionLineItem;

public interface PrescriptionLineItemRepository extends JpaRepository<PrescriptionLineItem, Integer>{

	
	//Find list of prescriptions by line item
	List<PrescriptionLineItem> findAllByprescriptionLineItemPrescription(Prescription prescription);
	List<PrescriptionLineItem> findAllByprescriptionLineItemPrescriptionPrescriptionID(int prescriptionId);
//	List<PrescriptionLineItem> findPrescriptionLineItemsByPrescriptionPrescriptionID(int prescriptionId);


//	Find list of lineItems by MedicineItem
	List<PrescriptionLineItem> findAllByLineItemMedicineMedicineItemID(int medicineItemID);
//	List<PrescriptionLineItem> findAllByLineItemMedicine(MedicineItem medItem);

//	@Query("select lineItems from PrescriptionLineItem lineItems where lineItems.lineItemMedicine.medicineItemID= :medicineID")
//	List<PrescriptionLineItem> findPrescriptionLineItemByMedId(@Param("medicineID") int medicineID);
}
