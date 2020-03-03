package com.example.demo.api;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.services.PatientService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/users/{pharmacyID}/patient")
public class PatientController {
	
	@Autowired
	PatientService pService;

	@GetMapping("/test")
	public String testEndpoint(){
		return "Test Patient Controller endpoint";
	}
	
	@PostMapping
	public Patient createNewPatient(@RequestBody Patient p) {
		pService.addNewPatient(p);
		return p;
	}
	
	@GetMapping("/all")
	public List<Patient> getPatients(@PathVariable String pharmacyID){
		
		//Go to service and get all patients where pharmacyID = PharmacyID
		//Right now just return all patients.
		System.out.println("Calling all patients");
		List<Patient> usersPatients = pService.getAllMyPatients(pharmacyID);
		return usersPatients;
		
	}
	
	@GetMapping("/{patientID}")
	public Optional<Patient> getPatientDetails(@PathVariable int patientID, @PathVariable String pharmacyID){
		
		//Go to service and get find Patient where pharmacyID = PharmacyID and id =id;
		//Right now just return all patients.
		
		//(Patient foundPatient = pService.findPatientByID)
		//return usersPatients;
		return pService.findPatientById(patientID, pharmacyID);
	}
	
	@PutMapping("/{patientID}")
	public void updatePatientDetails(@RequestBody Patient p, @PathVariable String pharmacyID) {
		pService.updatePatient(p, pharmacyID);
	}
}
