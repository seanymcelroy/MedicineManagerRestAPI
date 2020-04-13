package com.example.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Prescription {
	
	@Id@GeneratedValue(strategy= GenerationType.IDENTITY)
	int prescriptionID;
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	Patient patientOnPrescription;
	

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<LineItem> items;
	
	


	String instructions;
	String status; //BeingPrepared + Ready for PickUp + Dispensed
	
//	@Temporal(TemporalType.DATE)
//	Date prescriptionCreationDate;

	
	//Prescription definetly has a pharmacy
//	Pharmacy prescriptionFulfillers
	
	
	

	public int getPrescriptionID() {
		return prescriptionID;
	}


	public Set<LineItem> getItems() {
		return items;
	}



	public void setItems(Set<LineItem> items) {
		this.items = items;
	}


	public void setPrescriptionID(int prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public Patient getPatientOnPrescription() {
		return patientOnPrescription;
	}

	public void setPatientOnPrescription(Patient patientOnPrescription) {
		this.patientOnPrescription = patientOnPrescription;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public Date getPrescriptionCreationDate() {
//		return prescriptionCreationDate;
//	}
//
//	public void setPrescriptionCreationDate(Date prescriptionCreationDate) {
//		this.prescriptionCreationDate = prescriptionCreationDate;
//	}
	

	
	
}
	
	
	
	
	