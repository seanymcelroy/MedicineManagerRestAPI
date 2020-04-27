package com.example.demo.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Prescription;
import com.example.demo.model.user.Patient;
import com.example.demo.model.user.Pharmacy;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{

	//should add WHERE PHARMACY ID = PHARMACY
//	@Query("SELECT pr FROM Prescription pr JOIN FETCH pr.patientOnPrescription")
//	List<Prescription> findAll();
	
	List<Prescription> findAllByPrescriptionPatient(Patient patient);
	List<Prescription> findAllByPrescriptionPharmacy(Pharmacy pharmacy);
	
	//Find list of prescriptions by patient
	List<Prescription> findAllByPrescriptionPatientPatientID(int patientId);
	List<Prescription> findAllByPrescriptionPatientPatientEmail(String patientEmail);
	
	//Find List of prescriptions by Pharmacy
	List<Prescription> findAllByPrescriptionPharmacyPharmacyID(int pharmacyId);
	List<Prescription> findAllByPrescriptionPharmacyPharmacyEmail(String pharmacyEmail);
	
//	@Query("SELECT pr FROM Prescription pr JOIN FETCH pr.patientOnPrescription")
//	Optional<Prescription> findById();
}
