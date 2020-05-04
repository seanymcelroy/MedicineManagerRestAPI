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

import com.example.demo.dal.AppointmentRepository;
import com.example.demo.dal.ItemStockLevelRepository;
import com.example.demo.dal.MedicineItemRepository;
import com.example.demo.dal.PatientRepository;
import com.example.demo.dal.PharmacyRepository;
import com.example.demo.dal.PrescriptionLineItemRepository;
import com.example.demo.dal.PrescriptionRepository;
import com.example.demo.model.Appointment;
import com.example.demo.model.ItemStockLevel;
import com.example.demo.model.MedicineItem;
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
	PharmacyRepository mPharmacyRepo;
	
	@Autowired
	PatientRepository mPatientRepo;
	
	@Autowired
	MedicineItemRepository mMedicineItemRepo;
	
	@PostMapping("/createNewPharmacy")
	public boolean createNewPharmacyUser(@RequestBody Pharmacy nuevoPharmacy){
		
		if (mPharmacyRepo.existsPharmacyByPharmacyEmail(nuevoPharmacy.getPharmacyEmail()) == true || mPharmacyRepo.existsPharmacyByPharmacyName(nuevoPharmacy.getPharmacyName()) ==true || mPharmacyRepo.existsPharmacyByPsiRegistrationNumber(nuevoPharmacy.getPsiRegistrationNumber()) == true){
			return false;
		}else {
			for(MedicineItem medItem: mMedicineItemRepo.findAll()) {
				ItemStockLevel itemStock = new ItemStockLevel(0, medItem);
				nuevoPharmacy.addItemToStock(itemStock);
			}
			mPharmacyRepo.save(nuevoPharmacy);
			return true;
		}
	}
	
	//
//	@GetMapping("/getExamplePharmacy")
//	public Pharmacy getExamplePharmacy(){
//		
//		return mPharmacyRepo.getOne(1);
//	}
	//
	
	
	@PostMapping("/createNewPatient")
	public String createNewPatient(@RequestBody Patient patient) {
		if (mPatientRepo.existsByPatientEmail(patient.getPatientEmail())==true || mPatientRepo.existsPatientByPhoneNumber(patient.getPhoneNumber()) || mPatientRepo.existsPatientByPatientPPSNumber(patient.getPatientPPSNumber())) {
			return "User already exists with those details";
		}
		else {
			mPatientRepo.save(patient);
			return "New User created";
		}
		
	}
	
	//
//	@GetMapping("/getExamplePatient")
//	public Patient getExamplePtient(){
//		return mPatientRepo.getOne(1);
//	}
	//
}
