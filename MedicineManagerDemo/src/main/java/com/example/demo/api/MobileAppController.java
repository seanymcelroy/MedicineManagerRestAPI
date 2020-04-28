package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.PatientRepository;
import com.example.demo.model.Prescription;
import com.example.demo.model.user.Patient;
import com.example.demo.services.PrescriptionService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mobile")
public class MobileAppController {
	
	@Autowired
	PrescriptionService mPrescriptionService;
	
	@Autowired
	PatientRepository mPatientRepo;
	
	@GetMapping("/test")
	public String testPrescriptionController() {
		System.out.println("Mobiley app controller mthd test");
		return "Hi android app. from spring";
	}
	
	//Sign
	
	
	//Prescriptions
	
	@GetMapping("/getMyPrescriptions")
	public List<Prescription> getMyPrescriptions(){
		Patient p = mPatientRepo.getOne(1);
		return mPrescriptionService.getPatientPrescriptions(p.getPatientID());
		
	}
	
//	@GetMapping("/availablePharmacies")
//	public List<String> getAvailablePharmacies(){
//		return mPharmcyService.getListofPharmacyNames();
//		
//	}
//	
	
//	@GetMapping("/availableMedicines")
//	public List<String> getAvailableMedicines(){
//		return Medicines 
//	}
	
}
	
	
	
	
