package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

import com.example.demo.model.user.Patient;


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
		
	Long prescriptionCreationTime;

	String rxImageURI;
	
	//Prescription definetly has a pharmacy
//	Pharmacy prescriptionFulfillers
	
	
	public Prescription() {
		super();
	}


	public Prescription(Patient patientOnPrescription, String instructions, Long prescriptionCreationTime,
			String rxImageURI) {
		super();
		this.patientOnPrescription = patientOnPrescription;
		this.instructions = instructions;
		this.prescriptionCreationTime = prescriptionCreationTime;
		this.rxImageURI = rxImageURI;
	}









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

	public Long getPrescriptionCreationTime() {
		return prescriptionCreationTime;
	}

	public void setPrescriptionCreationTime(Long prescriptionCreationTime) {
		this.prescriptionCreationTime = prescriptionCreationTime;
	}

	public String getRxImageURI() {
		return rxImageURI;
	}


	public void setRxImageURI(String rxImageURI) {
		this.rxImageURI = rxImageURI;
	}


	@Override
	public String toString() {
		return "Prescription [prescriptionID=" + prescriptionID + ", patientOnPrescription=" + patientOnPrescription
				+ ", items=" + items + ", instructions=" + instructions + ", status=" + status
				+ ", prescriptionCreationTime=" + prescriptionCreationTime + ", rxImageURI=" + rxImageURI + "]";
	}

	
	

	

	
	
}
	
	
	
	
	