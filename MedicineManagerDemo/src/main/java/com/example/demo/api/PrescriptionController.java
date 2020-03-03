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
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/users/{pharmacyID}/prescription")
public class PrescriptionController {

	
	@Autowired
	PrescriptionService prescriptionService;
	
	@GetMapping("/test")
	public String testPrescriptionController() {
		System.out.println("Prescription controller test method reached");
		return "You made it to prescription controller";
	}
	
	
	
	@PostMapping("/add")
	public Prescription postAPrescription(@PathVariable String pharmacyID, @RequestBody Prescription pre) {
		prescriptionService.addNewPrescription(pre);
		return pre;
	}
	
	@GetMapping("/all")
	public List<Prescription> getAllPrescriptions(@PathVariable String pharmacyID){
		return prescriptionService.getAllMyPrescriptions(pharmacyID);
		
	}
	
}
