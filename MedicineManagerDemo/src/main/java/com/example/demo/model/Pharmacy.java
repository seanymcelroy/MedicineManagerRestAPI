package com.example.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

//@Entity
public class Pharmacy {

	//Persistence Provider must assign primary key Identity using column.
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pharmacyID;
	
	
	private String pharmacyEmail;
	
	private String pharmacyPassword;
	
	private String psiRegistrationNumber;
	
	
	private String pharmacyName;
	
	
	private String pharmacyContactNum;
	private String pharmacyAddress;

	
	@OneToMany(mappedBy = "patientPharmacy", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Patient> pharmacyPatientList;
	
	
//	@ManyToMany
//	private List<Medicine> medicineStock;
	


	

	public String getPharmacyEmail() {
		return pharmacyEmail;
	}

	

	public int getPharmacyID() {
		return pharmacyID;
	}



	//Empty Constructor
	public Pharmacy() {}






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


	public Set<Patient> getPharmacyPatientList() {
		return pharmacyPatientList;
	}


	public void setPharmacyPatientList(Set<Patient> pharmacyPatientList) {
		this.pharmacyPatientList = pharmacyPatientList;
	}



	@Override
	public String toString() {
		return "Pharmacy [pharmacyID=" + pharmacyID + ", pharmacyEmail=" + pharmacyEmail + ", pharmacyPassword="
				+ pharmacyPassword + ", psiRegistrationNumber=" + psiRegistrationNumber + ", pharmacyName="
				+ pharmacyName + ", pharmacyContactNum=" + pharmacyContactNum + ", pharmacyAddress=" + pharmacyAddress
				+ ", pharmacyPatientList=" + pharmacyPatientList + "]";
	}

	
	

	
	

	
	
	
	
}
