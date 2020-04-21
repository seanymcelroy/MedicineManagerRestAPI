package com.example.demo.model.user;

import java.time.LocalDate;
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
	
	
	LocalDate dateOfBirthInMilis;
	
	
	
	
	



}
