package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Prescription {
	
	@Id@GeneratedValue(strategy= GenerationType.IDENTITY)
	int prescriptionID;
	
	String prescriptionInstructions;
	String status; //BeingPrepared + Ready for PickUp + Dispensed
	
	@Temporal(TemporalType.DATE)
	Date prescriptionCreationDate;
	
	
	
	
	public int getPrescriptionID() {
		return prescriptionID;
	}
	public void setPrescriptionID(int prescriptionID) {
		this.prescriptionID = prescriptionID;
	}
	public String getPrescriptionInstructions() {
		return prescriptionInstructions;
	}
	public void setPrescriptionInstructions(String prescriptionInstructions) {
		this.prescriptionInstructions = prescriptionInstructions;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getPrescriptionCreationDate() {
		return prescriptionCreationDate;
	}
	public void setPrescriptionCreationDate(Date prescriptionCreationDate) {
		this.prescriptionCreationDate = prescriptionCreationDate;
	}
	
	

}
