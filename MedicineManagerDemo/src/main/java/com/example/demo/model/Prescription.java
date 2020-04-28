package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import com.example.demo.model.user.Pharmacy;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="prescriptionID", scope = Integer.class)
public class Prescription {
	
	@Id@GeneratedValue(strategy= GenerationType.IDENTITY)
	int prescriptionID;
	String patientMessage;
	String prescriptionStatus= "Submitted";
	Long prescriptionCreationDate = new Date().getTime();
	Long prescriptionFulfilmentDate;
	String prescriptionImageURI;
	String doctor;
	
	
	//Patient

//	@JsonIgnore
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	Patient prescriptionPatient;
		
	public void setPrescriptionPatient(Patient prescriptionPatient) {
		this.prescriptionPatient = prescriptionPatient;
	}
	

//	@JsonBackReference
	public Patient getPrescriptionPatient() {
		return prescriptionPatient;
	}
	
	public String getPatientFirstName() {
		return prescriptionPatient.getFirstName();
	}
	
	public String getPatientLastName() {
		return prescriptionPatient.getLastName();
	}
	
	///////////////////
	
	
	
	//PharmacyOnPrescription
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "pharmacy_id")
	Pharmacy prescriptionPharmacy;
	
	public Pharmacy getPrescriptionPharmacy() {
		return prescriptionPharmacy;
	}

	public void setPrescriptionPharmacy(Pharmacy prescriptionPharmacy) {
		this.prescriptionPharmacy = prescriptionPharmacy;
	}
	
	///////////
	
	
	
	//PrescriptionLineItems
	@OneToMany(mappedBy = "prescriptionLineItemPrescription", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIdentityReference(alwaysAsId = true)
	List<PrescriptionLineItem> prescriptionLineItems = new ArrayList<PrescriptionLineItem>();
	
	
	//Line item Helper method. Set line items from prescription from here only
	public void addPrescriptionLineItem(PrescriptionLineItem prescriptionLineItem) {
		this.prescriptionLineItems.add(prescriptionLineItem);
		prescriptionLineItem.setPrescriptionLineItemPrescription(this);
	}
	
	//Getters + setters
	public List<PrescriptionLineItem> getPrescriptionLineItems() {
		return prescriptionLineItems;
	}

	public void setPrescriptionLineItems(List<PrescriptionLineItem> prescriptionLineItems) {
		this.prescriptionLineItems = prescriptionLineItems;
	}
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////
	
	//Constructors
	

	public Prescription() {
		super();
	}
	


	public Prescription(int prescriptionID, String patientMessage, String prescriptionStatus,
			Long prescriptionCreationDate, Long prescriptionFulfilmentDate, String prescriptionImageURI,
			String doctor) {
		super();
		this.prescriptionID = prescriptionID;
		this.patientMessage = patientMessage;
		this.prescriptionStatus = "Submitted";
		this.prescriptionCreationDate = new Date().getTime();
		this.prescriptionFulfilmentDate = prescriptionFulfilmentDate;
		this.prescriptionImageURI = prescriptionImageURI;
		this.doctor = doctor;
	}
	
	
	
	
	
	//Getters + Setters
	
	
	public int getPrescriptionID() {
		return prescriptionID;
	}
	public void setPrescriptionID(int prescriptionID) {
		this.prescriptionID = prescriptionID;
	}
	public String getPatientMessage() {
		return patientMessage;
	}
	public void setPatientMessage(String patientMessage) {
		this.patientMessage = patientMessage;
	}
	public String getPrescriptionStatus() {
		return prescriptionStatus;
	}
	public void setPrescriptionStatus(String prescriptionStatus) {
		this.prescriptionStatus = prescriptionStatus;
	}
	public Long getPrescriptionCreationDate() {
		return prescriptionCreationDate;
	}
	public void setPrescriptionCreationDate(Long prescriptionCreationDate) {
		this.prescriptionCreationDate = prescriptionCreationDate;
	}
	public Long getPrescriptionFulfilmentDate() {
		return prescriptionFulfilmentDate;
	}
	public void setPrescriptionFulfilmentDate(Long prescriptionFulfilmentDate) {
		this.prescriptionFulfilmentDate = prescriptionFulfilmentDate;
	}
	public String getPrescriptionImageURI() {
		return prescriptionImageURI;
	}
	public void setPrescriptionImageURI(String prescriptionImageURI) {
		this.prescriptionImageURI = prescriptionImageURI;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	

	

	
	
	
	

	
	
}
	
	
	
	
	