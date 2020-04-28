package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.model.user.Patient;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="appointmentId", scope = Integer.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int appointmentId;
//	
	 private String appointmenttitle;
	 private String additionalInfo;
	 private Long timeinMillis;
	 
	 @JsonIdentityReference(alwaysAsId = true)
	 @JoinColumn(name = "patient_id")
	 @ManyToOne(fetch = FetchType.LAZY)
	 Patient appointmentPatient;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointmenttitle() {
		return appointmenttitle;
	}

	public void setAppointmenttitle(String appointmenttitle) {
		this.appointmenttitle = appointmenttitle;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Long getTimeinMillis() {
		return timeinMillis;
	}

	public void setTimeinMillis(Long timeinMillis) {
		this.timeinMillis = timeinMillis;
	}

	public Patient getAppointmentPatient() {
		return appointmentPatient;
	}

	public void setAppointmentPatient(Patient appointmentPatient) {
		this.appointmentPatient = appointmentPatient;
	}
	 
	
	

}
