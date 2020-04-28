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
	public List<Patient> getPharmacyPatients(){
		 Pharmacy p =mPharmacyRepo.getOne(1);
		 List<Prescription> pharmacyPrescriptions = mPrescriptionService.getPharmacyPrescriptions(p);
		 
		 System.out.println(pharmacyPrescriptions.size());
		 List<Patient> pharmacyPatients = new ArrayList<>();
		 
		 //Check all your prescriptions
		 for(Prescription prescription : pharmacyPrescriptions) {
			 Patient patientOnPrescription = prescription.getPrescriptionPatient();
			 if(!pharmacyPatients.contains(patientOnPrescription)) {
				 pharmacyPatients.add(patientOnPrescription);
			 }
		 }
		 System.out.println(pharmacyPatients.size());
		 
		 return pharmacyPatients;
	}
	
	
	@GetMapping("/getPatientPrescriptions/{patientID}")
	public List<Prescription> getMyPatientsPrescriptions(@PathVariable("patientID") int patientID){
		Pharmacy p =mPharmacyRepo.getOne(1);
		
		//System.out.println(patientID);
		//Check to see if pharmacy has a prescription with patient before allowing access to all prescription

		
		if (mPrescriptionService.hasPharmacyAccessToPatient(p.getPharmacyID() ,patientID)==true) {
			return mPrescriptionService.getPatientPrescriptions(patientID);
		}
		
		return null;
	}
	
	
	
	@GetMapping("/getMyPrescriptions")
	public List<Prescription> getMyPrescriptions(){
		Pharmacy p = mPharmacyRepo.getOne(1);
		return mPrescriptionService.getPharmacyPrescriptions(p);
	}
	
	
	@GetMapping("/getPrescription/{prescriptionID}")
	public Prescription getPrescription(@PathVariable("prescriptionID") int prescriptionID) {
		Pharmacy pharm = mPharmacyRepo.getOne(1);
		
		Prescription prescription = mPrescriptionService.getPrescriptionByID(prescriptionID);
		Patient patient =prescription.getPrescriptionPatient();
		
		//If one of the pharmacy patients it can view it
		if(mPrescriptionService.hasPharmacyAccessToPatient(pharm.getPharmacyID(), patient.getPatientID())==true) {
			return prescription;
		}
		
		return null;	
	}
}
