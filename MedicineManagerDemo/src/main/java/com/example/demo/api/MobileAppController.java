package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.PrescriptionRepository;
import com.example.demo.model.Medicine;
import com.example.demo.model.Patient;
import com.example.demo.model.Prescription;
import com.example.demo.services.MedicineService;
import com.example.demo.services.PatientService;
import com.example.demo.services.PrescriptionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mobile")
public class MobileAppController {
	
	@Autowired
	PrescriptionService mPrescriptionService;
	
	@GetMapping("/test")
	public String testPrescriptionController() {
		System.out.println("Mobiley app controller mthd test");
		return "Hi android app. from spring";
	}
	
	
	@GetMapping("/myprescriptions")
	public List<Prescription> getAllPrescriptionsTest(){
		
		String patientID = "dummyPatientID"; 
		return mPrescriptionService.getPatientPrescriptions(patientID);
	}
	
	
	
	
}