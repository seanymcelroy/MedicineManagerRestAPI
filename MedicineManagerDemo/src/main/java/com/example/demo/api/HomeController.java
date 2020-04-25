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
import com.example.demo.dal.PharmacyRepository;
import com.example.demo.dal.PrescriptionLineItemRepository;
import com.example.demo.dal.PrescriptionRepository;
import com.example.demo.model.Prescription;
import com.example.demo.model.PrescriptionLineItem;
import com.example.demo.model.user.Patient;
import com.example.demo.model.user.Pharmacy;

//Rest controller indicates data returned by each method will be written straight into response body. no template rendered
//CrossOrigin allows resource sharing to other servers
@RestController
@CrossOrigin(origins="*")
public class HomeController {
	
	
	@Autowired
	PatientRepository mPatientRepo;
	
	@Autowired
	PrescriptionRepository mPrescriptionRepo;
	
	@Autowired
	PharmacyRepository mPharmacyRepo;
	
	@Autowired
	PrescriptionLineItemRepository mPrescriptionLineItemRepo;
	
	
	@GetMapping("/test")
	public String testEndpoint(){
		return "Test endpoint in Home Controller reached. (permit all)";
	}

	
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
	
	@PostMapping("/newPrescription/{pharmacyName}")
	public void createNewPrescription(@RequestBody Prescription prescription, @PathVariable("pharmacyName") String pharmacyName) {
		
		//Will be replace with Principal when Security added
		Patient patient = mPatientRepo.findById(1).get();
		
		Pharmacy pharmacy = mPharmacyRepo.findByPharmacyName(pharmacyName);
		
		
		prescription.setPrescriptionPharmacy(pharmacy);
		patient.addPrescription(prescription);
		mPatientRepo.save(patient);
		
	}
	
	
	@GetMapping("/patient")
	public Patient getPatient() {
		
		Patient patient = mPatientRepo.findById(1).get();
		return patient;
		
	}
	
	@GetMapping("/pharmacy")
	public Pharmacy getPharmacy() {
		
		Pharmacy pharmacy = mPharmacyRepo.findById(1).get();
		return pharmacy;
		
	}
	
	
	@GetMapping("/prescription")
	public Prescription getPrescription() {
		
		Prescription prescription = mPrescriptionRepo.findById(1).get();
		return prescription;
		
	}
	
	@GetMapping("/patientPrescriptions")
	public List<Prescription> getPatientPrescriptions() {
		return mPrescriptionRepo.findPrescriptionsByPrescriptionPatientPatientID(2);
	}
	
	@GetMapping("/pharmacyPrescriptions")
	public List<Prescription> getPharmacyPrescriptions(){
		return mPrescriptionRepo.findPrescriptionsByPrescriptionPharmacyPharmacyID(1);
	}
	
//	@GetMapping("/prescriptionLineItems")
//	public List<PrescriptionLineItem> getPrescriptionLineItems(){
////		Prescription p = mPrescriptionRepo.findById(1);
//		//return mPrescriptionLineItemRepo.findPrescriptionLineItemsByPrescriptionPrescriptionID(1);
//	}


	
	
	@PostMapping("/newPharmacy")
	public String createNewPharmacy(@RequestBody Pharmacy pharmacy) {
		if (mPharmacyRepo.existsPharmacyByPharmacyName(pharmacy.getPharmacyName())==false && mPharmacyRepo.existsPharmacyByPharmacyEmail(pharmacy.getPharmacyEmail())==false)  {
			mPharmacyRepo.save(pharmacy);
			return "Pharmacy Created";
		}
		else {
			return "Pharmacy with same email or same name";
		}
		
	}
	
}
