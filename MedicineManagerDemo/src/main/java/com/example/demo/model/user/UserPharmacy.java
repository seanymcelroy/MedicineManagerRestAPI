package com.example.demo.model.user;

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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
//@Table(name = "User")
public class UserPharmacy {

	//Persistence Provider must assign primary key Identity using column.
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int userID;
	
	@Id
	private String userName;
	
	private String password;
	
	private boolean active;
	
		
	private String roles;
	
	
	//other attributes
	private String pharmacyName;
	
	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public String getPharmacyName() {
		return pharmacyName;
	}


	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	
	
	
	
	


	
//	@OneToMany(mappedBy = "patientPharmacy", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<Patient> pharmacyPatientList;
	
	
//	@ManyToMany
//	private List<Medicine> medicineStock;
	


	


	

	
	
	
	
}
