package com.example.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Prescription {
	
	@Id@GeneratedValue(strategy= GenerationType.IDENTITY)
	int prescriptionID;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	Patient patientOnPrescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Prescriber_ID")
	Doctor prescriber;
	
	
	
//	@ElementCollection
//	@CollectionTable(name="Prescription_Medicines")
//	@JoinColumn(name="Prescription_ID")
//	@Column(name="Quantity_Prescribed")
//	@MapKeyJoinColumn(name="Medicine_ID")
//    Map<Medicine, Integer> prescribedMeds;
//	//Medicine prescribedMed;
	
	@ManyToMany
	private List<Medicine> medicinesPrescribed;
	
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

	public Patient getPatientOnPrescription() {
		return patientOnPrescription;
	}

	public void setPatientOnPrescription(Patient patientOnPrescription) {
		this.patientOnPrescription = patientOnPrescription;
	}

	public Doctor getPrescriber() {
		return prescriber;
	}

	public void setPrescriber(Doctor prescriber) {
		this.prescriber = prescriber;
	}

	public List<Medicine> getMedicinesPrescribed() {
		return medicinesPrescribed;
	}

	public void setMedicinesPrescribed(List<Medicine> medicinesPrescribed) {
		this.medicinesPrescribed = medicinesPrescribed;
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

	@Override
	public String toString() {
		return "Prescription [prescriptionID=" + prescriptionID + ", patientOnPrescription=" + patientOnPrescription
				+ ", prescriber=" + prescriber + ", medicinesPrescribed=" + medicinesPrescribed
				+ ", prescriptionInstructions=" + prescriptionInstructions + ", status=" + status
				+ ", prescriptionCreationDate=" + prescriptionCreationDate + "]";
	}
	
	
	
}
	
	
	
	
	