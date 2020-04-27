package com.example.demo.model.user;

import java.util.ArrayList;
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

import com.example.demo.model.ItemStockLevel;
import com.example.demo.model.Prescription;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="pharmacyID", scope = Integer.class)
public class Pharmacy {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pharmacyID;
	@Column(unique=true)
	String pharmacyEmail;
	String pharmacyPassword;
	@Column(unique=true)
	String pharmacyName;
	@Column(unique=true)
	String psiRegistrationNumber;
	String contactNumber;
	String pharmacyAddress;
	
	
	//Prescriptions
	@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(mappedBy = "prescriptionPharmacy", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Prescription> pharmacyPrescriptions = new ArrayList<Prescription>();
	
	
	//Prescription Helper method. Set prescription from here only
//	public void addPrescription(Prescription prescription) {
//		this.pharmacyPrescriptions.add(prescription);
//		prescription.setPrescriptionPharmacy(this);
//	}
	
	public List<Prescription> getPharmacyPrescriptions() {
		return pharmacyPrescriptions;
	}

	public void setPharmacyPrescriptions(List<Prescription> pharmacyPrescriptions) {
		this.pharmacyPrescriptions = pharmacyPrescriptions;
	}
	
//	////////////////////////////
	
//	@JsonIdentityReference(alwaysAsId = true)
	@JsonIgnore
	@OneToMany(mappedBy = "itemStockPharmacy", cascade = CascadeType.ALL, orphanRemoval = true)
	List<ItemStockLevel> itemStockLevels = new ArrayList<ItemStockLevel>();
	
	@JsonIdentityReference(alwaysAsId = true)
	public List<ItemStockLevel> getItemStockLevel() {
		return itemStockLevels;
	}
	
	public void addItemToStock(ItemStockLevel item) {
		this.itemStockLevels.add(item);
		item.setItemStockPharmacy(this);
	}

//	public void setItemStockLevel(List<ItemStockLevel> itemStockLevels) {
//		this.itemStockLevels = itemStockLevels;
//	}

	////////
	public Pharmacy() {
		super();
	}


	public Pharmacy(String pharmacyEmail, String pharmacyPassword, String pharmacyName, String psiRegistrationNumber,
			String contactNumber, String pharmacyAddress) {
		super();
		this.pharmacyEmail = pharmacyEmail;
		this.pharmacyPassword = pharmacyPassword;
		this.pharmacyName = pharmacyName;
		this.psiRegistrationNumber = psiRegistrationNumber;
		this.contactNumber = contactNumber;
		this.pharmacyAddress = pharmacyAddress;
	}


	public int getPharmacyID() {
		return pharmacyID;
	}


	public void setPharmacyID(int pharmacyID) {
		this.pharmacyID = pharmacyID;
	}


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


	public String getPharmacyName() {
		return pharmacyName;
	}


	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}


	public String getPsiRegistrationNumber() {
		return psiRegistrationNumber;
	}


	public void setPsiRegistrationNumber(String psiRegistrationNumber) {
		this.psiRegistrationNumber = psiRegistrationNumber;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getPharmacyAddress() {
		return pharmacyAddress;
	}


	public void setPharmacyAddress(String pharmacyAddress) {
		this.pharmacyAddress = pharmacyAddress;
	}
	

	
	
	
}
