package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
public class Patient {
	
//	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	
	private String patientFirstName;
	private String patientSurname;
	private String patientPhoneNumber;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pharmacy_id")
	private Pharmacy patientPharmacy;
	
	@OneToMany(mappedBy = "patientOnPrescription",  cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Prescription> prescriptions;
	
	//Year month date
	@Temporal(TemporalType.DATE)
	private Date patientDateOfBirth;
	
	
	//Each Pharmacy Patient will have a list of Prescriptions
	
	Patient(){}
	
	
	
	

	
	public Patient(int patientId, String patientFirstName, String patientSurname, String patientPhoneNumber) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientSurname = patientSurname;
		this.patientPhoneNumber = patientPhoneNumber;
	}


	//Getters Plus Setters for Patient

	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	
	public String getPatientSurname() {
		return patientSurname;
	}
	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}
//	public Date getPatientDateOfBirth() {
//		return patientDateOfBirth;
//	}
//	public void setPatientDateOfBirth(Date patientDateOfBirth) {
//		this.patientDateOfBirth = patientDateOfBirth;
//	}
	
	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}
	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}
	

	
	

}
