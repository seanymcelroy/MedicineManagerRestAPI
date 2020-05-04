package com.example.demo.dal;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.user.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Integer>{


	boolean existsByPatientEmail(String patientEmai);
	boolean existsPatientByPhoneNumber(String phoneNumber);
	boolean existsPatientByPatientPPSNumber(String ppsNumber);
	
	Patient findByPatientEmail(String patientEmail);
	
//	Patient findPatientByPatientPrescriptionsID(int prescriptionID);
	
	
}
