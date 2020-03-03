package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.PatientRepository;
import com.example.demo.model.Patient;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepo;
	
	
	public void addNewPatient(Patient p) {
		patientRepo.save(p);
	}
	
	public void updatePatient(Patient p, String pharmID) {
//		Optional<Patient> pat = findPatientById(p.getPatientId(), pharmID);
//		if(p!=null) {
//			
//			patientRepo.save(pat.get());
//		}
		System.out.println(p.getPatientId());
		System.out.println(p.getPatientFirstName());
		patientRepo.save(p);
	}
	
	public List<Patient> getAllMyPatients(String pharmacyID){
		
		//Find Pharmacy by ID. find patients where pharmacy is that retrieved Pharmacy
		//PharmacyService.FindBYID(pharmacyID)
		List<Patient> foundPatients = patientRepo.findAll();
		return foundPatients;
	}
	
	
	public Optional<Patient> findPatientById(int patientID, String pharmacyID){
		
		//Find Pharmacy by ID. find patients where pharmacy is that retrieved Pharmacy
		//PharmacyService.FindBYID(pharmacyID)
		Optional<Patient> foundPatient = patientRepo.findById(patientID);
		return foundPatient;
	}
}
