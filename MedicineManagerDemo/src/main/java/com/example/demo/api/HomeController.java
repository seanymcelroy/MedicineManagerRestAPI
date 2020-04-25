package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.PatientRepository;
import com.example.demo.dal.PrescriptionRepository;
import com.example.demo.model.Prescription;
import com.example.demo.model.user.Patient;

//Rest controller indicates data returned by each method will be written straight into response body. no template rendered
//CrossOrigin allows resource sharing to other servers
@RestController
@CrossOrigin(origins="*")
public class HomeController {
	
	
	@Autowired
	PatientRepository mPatientRepo;
	
	@Autowired
	PrescriptionRepository mPrescriptionRepo;
	
	@GetMapping("/test")
	public String testEndpoint(){
		return "Test endpoint in Home Controller reached. (permit all)";
	}


//	@Autowired
//	PharmacyService pharmacyService;
//
//	
//	@Autowired
//	PatientService mPatientService;
//	
//	
//	@PostMapping("/newPharm")
//	public String createNewPharmacy(@RequestBody Pharmacy pharmacyNue) {
//		if (pharmacyService.createNewPharmacyUser(pharmacyNue)==true) {
//			return "Pharmacy Created";
//		}
//		else {
//			return "Pharmacy with same email or same name or same psiNumber exists";
//		}
//		
//	}
//	
//	
	
	
//	@PostMapping("/newPatient")
//	public String createNewPatient(@RequestBody Patient patient) {
//		if (mPatientService.createNewPatientUser(patient)==true) {
//			return "Patient Created";
//		}
//		else {
//			return "Patient with same email or same name phone Number exists";
//		}
//		
//	}
	
	@PostMapping("/newPatient")
	public String createNewPatient(@RequestBody Patient patient) {
		if (mPatientRepo.existsByPatientEmail(patient.getPatientEmail())==false) {
			mPatientRepo.save(patient);
			return "Patient Created";
		}
		else {
			return "Patient with same email or same name phone Number exists";
		}
		
	}
	
	@PostMapping("/newPrescription")
	public void createNewPrescription(@RequestBody Prescription prescription) {
		
		Patient patient = mPatientRepo.findById(1).get();
		patient.addPrescription(prescription);
		
		mPatientRepo.save(patient);
		
	}
	
	
	@GetMapping("/patient")
	public Patient getPatient() {
		
		Patient patient = mPatientRepo.findById(1).get();
		return patient;
		
	}
	
	
	@GetMapping("/prescription")
	public Prescription getPrescription() {
		
		Prescription prescription = mPrescriptionRepo.findById(1).get();
		return prescription;
		
	}
	
	@GetMapping("/patientprescription")
	public List<Prescription> getPatientPrescriptions() {
		return mPrescriptionRepo.findPrescriptionsByPrescriptionPatientPatientID(1);
	}

}
