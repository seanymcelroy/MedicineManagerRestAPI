package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.PrescriptionRepository;
import com.example.demo.model.Prescription;

@Service
public class PrescriptionService {

	
		
		@Autowired
		private PrescriptionRepository prescriptionRepo;
		
		
		public void addNewPrescription(Prescription p) {
			prescriptionRepo.save(p);
		}
		
		//Must be changed for specific pharmacy
		public List<Prescription> getPharmacyPrescriptions(String pharmacyID){
			return prescriptionRepo.findAll();
			
		}
		
		//Must be changed for specific patient
		public List<Prescription> getPatientPrescriptions(String patientID){
			return prescriptionRepo.findAll();
			
		}
		
		public Optional<Prescription> getPrescriptionByID(String pharmacyID, String prescriptionID) {
			return prescriptionRepo.findById(Integer.parseInt(prescriptionID));
		}
}
