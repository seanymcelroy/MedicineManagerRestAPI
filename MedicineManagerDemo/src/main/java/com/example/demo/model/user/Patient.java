package com.example.demo.model.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import com.example.demo.model.Appointment;
import com.example.demo.model.Prescription;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="patientID", scope = Integer.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	int patientID;
	
	@Column(unique = true)
	private String patientEmail;
	
	@JsonIgnoreProperties
	private String patientPassword;
	
	
	@Column(unique = true)
	@JsonIgnoreProperties
	private String patientPPSNumber;
	private String gender;
	private String firstName;
	private String lastName;
	private String patientAddress;
	private String phoneNumber;	
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate dateOfBirth;
	
	//Prescriptions
//	@JsonIdentityReference(alwaysAsId = true)
	@JsonIgnore
	@OneToMany(mappedBy = "prescriptionPatient", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Prescription> patientPrescriptions = new ArrayList<Prescription>();
	
	
	//Prescription Helper method. Set prescription from here only
	public void addPrescription(Prescription prescription) {
		this.patientPrescriptions.add(prescription);
		prescription.setPrescriptionPatient(this);
	}
	/////////////////////
	
//	@JsonManagedReference
	public List<Prescription> getPatientPrescriptions() {
		return patientPrescriptions;
	}
	
	
	//Appointments
	@JsonIgnore
	@OneToMany(mappedBy = "appointmentPatient", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Appointment> patientAppointments = new ArrayList<Appointment>();
	
	public void addAppointment(Appointment appointment) {
		this.patientAppointments.add(appointment);
		appointment.setAppointmentPatient(this);
	}

	
	
	//
	
	
	public Patient() {
		super();
	}
	
	
	
	
	





	public Patient(int patientID, String patientEmail, String patientPassword, String patientPPSNumber, String gender,
			String firstName, String lastName, String patientAddress, String phoneNumber, LocalDate dateOfBirth,
			List<Prescription> patientPrescriptions, List<Appointment> patientAppointments) {
		super();
		this.patientID = patientID;
		this.patientEmail = patientEmail;
		this.patientPassword = patientPassword;
		this.patientPPSNumber = patientPPSNumber;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.patientAddress = patientAddress;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.patientPrescriptions = patientPrescriptions;
		this.patientAppointments = patientAppointments;
	}
	///Getters + Setters
	
	
	
	public void setPatientPrescriptions(List<Prescription> patientPrescriptions) {
		this.patientPrescriptions = patientPrescriptions;
	}



	public int getPatientID() {
		return patientID;
	}
	
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	
	public String getPatientPassword() {
		return patientPassword;
	}
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	public String getPatientPPSNumber() {
		return patientPPSNumber;
	}

	public void setPatientPPSNumber(String patientPPSNumber) {
		this.patientPPSNumber = patientPPSNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	

	
	
	
	
	
	



}
