package com.example.demo.services;

import java.util.List;

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
		
		public List<Prescription> getAllMyPrescriptions(String pharmacyID){
			return prescriptionRepo.findAll();
			
		}
}
