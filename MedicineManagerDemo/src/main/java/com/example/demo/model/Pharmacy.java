package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pharmacy {

	@Id
	private String pharmacyRegNumber;
	private String pharmacyName;
	private String pharmacyContactNum;
	private String pharmacyAddress;
	private String pharmacyEmail;
	
	public String getPharmacyRegNumber() {
		return pharmacyRegNumber;
	}
	public void setPharmacyRegNumber(String pharmacyRegNumber) {
		this.pharmacyRegNumber = pharmacyRegNumber;
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
	
	
	public String getPharmacyEmail() {
		return pharmacyEmail;
	}
	public void setPharmacyEmail(String pharmacyEmail) {
		this.pharmacyEmail = pharmacyEmail;
	}
	
	
	@Override
	public String toString() {
		return "Pharmacy [pharmacyRegNumber=" + pharmacyRegNumber + ", pharmacyName=" + pharmacyName
				+ ", pharmacyContactNum=" + pharmacyContactNum + ", pharmacyAddress=" + pharmacyAddress
				+ ", pharmacyEmail=" + pharmacyEmail + "]";
	}
	
	
	
	
	
	
}
