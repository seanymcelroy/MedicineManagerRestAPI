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

@Entity
public class Patient {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	
	private String patientFirstName;
	private String patientSurname;
	private String address;
	private String phoneNumber;
	//Year month date
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "pharmacy_id")
//	private Pharmacy patientPharmacy;
	
//	@OneToMany(mappedBy = "patientOnPrescription",  cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Prescription> prescriptions;
//	
//
//    public void addPrescription(Prescription pres) {
//    	prescriptions.add(pres);
//        pres.setPatient(this);
//    }
 
//    List<Prescriptions> prescriptions = entityManager.createQuery(
//    	    "select prescr " +
//    	    "from Prescription prescr " +
//    	    "where presc.patient.id = :postId", PostComment.class)
//    	.setParameter( "postId", 1L )
//    	.getResultList();
	
	//Each Pharmacy Patient will have a list of Prescriptions
	
	Patient(){}


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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



}
