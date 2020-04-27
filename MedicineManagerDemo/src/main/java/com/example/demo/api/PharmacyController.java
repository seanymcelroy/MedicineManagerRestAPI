package com.example.demo.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.ItemStockLevelRepository;
import com.example.demo.dal.PharmacyRepository;
import com.example.demo.model.ItemStockLevel;
import com.example.demo.model.MedicineItem;
import com.example.demo.model.Prescription;
import com.example.demo.model.user.Patient;
import com.example.demo.model.user.Pharmacy;
import com.example.demo.services.MedicineService;
import com.example.demo.services.PrescriptionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pharmacy")
public class PharmacyController {
	
	@Autowired
	ItemStockLevelRepository mStockRepo;
	
	@Autowired PharmacyRepository mPharmacyRepo;
	
	@Autowired MedicineService mMedicineService;
	
	
	@Autowired PrescriptionService mPrescriptionService;
	
	
	@GetMapping("/test")
	public String pharmacytest() {
		return "Hi from pharmacy test method";
	}
	
	
	
	@GetMapping("/allStock")
	public List<ItemStockLevel> getStockItems(){
		Pharmacy p = mPharmacyRepo.getOne(1);
		return mStockRepo.findAllByItemStockPharmacy(p);
	}
	
	@GetMapping("/medicine/{barcode}")
	public MedicineItem fetchMedItemByBarcode(@PathVariable("barcode") String barcode) {
		return mMedicineService.getMedicineItemByBarcode(barcode);
		
	}
	
	@GetMapping("/getMyPatients")
	public void getPharmacyPatients(){
		 Pharmacy p =mPharmacyRepo.getOne(1);
		 List<Prescription> pharmacyPrescriptions = mPrescriptionService.getPharmacyPrescriptions(p);
		 
		 System.out.println(pharmacyPrescriptions.size());
		 List<Patient> pharmacyPatients = new ArrayList<>();
		 
		 for(Prescription prescription : pharmacyPrescriptions) {
			 Patient patientOnPrescription = prescription.getPrescriptionPatient();
			 if(!pharmacyPatients.contains(prescription)) {
				 pharmacyPatients.add(patientOnPrescription);
			 }
		 }
		 System.out.println(pharmacyPatients.size());
//		 
//		return pharmacyPatients;
	}

}
