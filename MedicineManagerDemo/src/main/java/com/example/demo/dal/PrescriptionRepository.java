package com.example.demo.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Prescription;
import com.example.demo.model.user.Patient;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{

	//should add WHERE PHARMACY ID = PHARMACY
//	@Query("SELECT pr FROM Prescription pr JOIN FETCH pr.patientOnPrescription")
//	List<Prescription> findAll();
	
	List<Prescription> findPrescriptionsByPrescriptionPatient(Patient patient);
	
	List<Prescription> findPrescriptionsByPrescriptionPatientPatientID(int patientId);
	List<Prescription> findPrescriptionsByPrescriptionPatientPatientEmail(String patientEmail);
//	@Query("SELECT pr FROM Prescription pr JOIN FETCH pr.patientOnPrescription")
//	Optional<Prescription> findById();
}
