package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="prescriptionLineItemID", scope = Integer.class)
public class PrescriptionLineItem{
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prescriptionLineItemID;
	
	int prescriptionLineItemQty;
	String prescriptionLineItemInstructions;
	
	
	
	//Prescription
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(fetch =FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH})
	@JoinColumn(name = "prescription_id")
	Prescription prescriptionLineItemPrescription;

	
	public Prescription getPrescriptionLineItemPrescription() {
		return prescriptionLineItemPrescription;
	}


	public void setPrescriptionLineItemPrescription(Prescription prescriptionLineItemPrescription) {
		this.prescriptionLineItemPrescription = prescriptionLineItemPrescription;
	}

	
	//MedicineItem
	
	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name ="Medicine_Item_ID")
//	@JsonIdentityReference(alwaysAsId = true)
	MedicineItem lineItemMedicine;
	

	public MedicineItem getLineItemMedicine() {
		return lineItemMedicine;
	}


	public void setLineItemMedicine(MedicineItem lineItemMedicine) {
		this.lineItemMedicine = lineItemMedicine;
	}
	
	
	
	
	//Constructors




	public PrescriptionLineItem() {
		super();
	}

	public PrescriptionLineItem(int prescriptionLineItemQty,
			String prescriptionLineItemInstructions) {
		super();
		this.prescriptionLineItemQty = prescriptionLineItemQty;
		this.prescriptionLineItemInstructions = prescriptionLineItemInstructions;
	}

	public int getPrescriptionLineItemID() {
		return prescriptionLineItemID;
	}


	public void setPrescriptionLineItemID(int prescriptionLineItemID) {
		this.prescriptionLineItemID = prescriptionLineItemID;
	}


	public int getPrescriptionLineItemQty() {
		return prescriptionLineItemQty;
	}


	public void setPrescriptionLineItemQty(int prescriptionLineItemQty) {
		this.prescriptionLineItemQty = prescriptionLineItemQty;
	}


	public String getPrescriptionLineItemInstructions() {
		return prescriptionLineItemInstructions;
	}


	public void setPrescriptionLineItemInstructions(String prescriptionLineItemInstructions) {
		this.prescriptionLineItemInstructions = prescriptionLineItemInstructions;
	}


	
	
}