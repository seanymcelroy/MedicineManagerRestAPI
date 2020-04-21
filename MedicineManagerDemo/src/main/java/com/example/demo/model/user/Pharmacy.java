package com.example.demo.model.user;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pharmacy {

	@Id
	private String pharmacyEmail;
	
	private String pharmacyPassword;
	
	@Column(unique=true)
	private String psiRegistrationNumber;
	
	@Column(unique=true)
	private String pharmacyName;
	
	
	private String pharmacyContactNum;
	private String pharmacyAddress;

	
//	@OneToMany(mappedBy = "patientPharmacy", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<Patient> pharmacyPatientList;


	public String getPharmacyEmail() {
		return pharmacyEmail;
	}


	public void setPharmacyEmail(String pharmacyEmail) {
		this.pharmacyEmail = pharmacyEmail;
	}


	public String getPharmacyPassword() {
		return pharmacyPassword;
	}


	public void setPharmacyPassword(String pharmacyPassword) {
		this.pharmacyPassword = pharmacyPassword;
	}


	public String getPsiRegistrationNumber() {
		return psiRegistrationNumber;
	}


	public void setPsiRegistrationNumber(String psiRegistrationNumber) {
		this.psiRegistrationNumber = psiRegistrationNumber;
	}


	public String getPharmacyName() {
		return pharmacyName;
	}


	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}


	public String getPharmacyContactNum() {
		return pharmacyContactNum;
	}


	public void setPharmacyContactNum(String pharmacyContactNum) {
		this.pharmacyContactNum = pharmacyContactNum;
	}


	public String getPharmacyAddress() {
		return pharmacyAddress;
	}


	public void setPharmacyAddress(String pharmacyAddress) {
		this.pharmacyAddress = pharmacyAddress;
	}



	
//	@ManyToMany
//	private List<Medicine> medicineStock;
	

	
	

	
	

	
	
	
	
}
