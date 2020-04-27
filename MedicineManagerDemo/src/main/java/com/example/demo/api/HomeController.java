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

import com.example.demo.dal.ItemStockLevelRepository;
import com.example.demo.dal.MedicineItemRepository;
import com.example.demo.dal.PatientRepository;
import com.example.demo.dal.PharmacyRepository;
import com.example.demo.dal.PrescriptionLineItemRepository;
import com.example.demo.dal.PrescriptionRepository;
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
	PatientRepository mPatientRepo;
	
	@Autowired
	PrescriptionRepository mPrescriptionRepo;
	
	@Autowired
	PharmacyRepository mPharmacyRepo;
	
	@Autowired
	PrescriptionLineItemRepository mPrescriptionLineItemRepo;
	
	
	@Autowired
	MedicineItemRepository mMedicineItemRepo;
	
	
	@Autowired
	ItemStockLevelRepository mItemStockLevelRepo;
	
	
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
	

	
	//Line Item test get
	@GetMapping("/prescriptionLineItemsMed")
	public List<PrescriptionLineItem> getaPrescriptionLineItemsByMedicine(){
		//Prescription p = mPrescriptionRepo.findById(1).get();
		//return mPrescriptionLineItemRepo.findAllByprescriptionLineItemPrescription(p);
		
		//MedicineItem medItem = mMedicineItemRepo.getOne(2);
		return mPrescriptionLineItemRepo.findAllByLineItemMedicineMedicineItemID(2);
	}
	
	
	//Line Item test post
	@PostMapping("/updatePrescription")
	public void addaPrescriptionLineItems(){
		//Probably be in body of prescription
		Prescription p = mPrescriptionRepo.getOne(1);
		PrescriptionLineItem prescritionLineItem= new PrescriptionLineItem(8, "Before bed");
		MedicineItem medicineItem = mMedicineItemRepo.getOne(2);
		
		prescritionLineItem.setLineItemMedicine(medicineItem);
		
		p.addPrescriptionLineItem(prescritionLineItem);
		
		mPrescriptionRepo.save(p);
	}


	
	
	@PostMapping("/newPharmacy")
	public String createNewPharmacy(@RequestBody Pharmacy pharmacy) {
		if (mPharmacyRepo.existsPharmacyByPharmacyName(pharmacy.getPharmacyName())==false && mPharmacyRepo.existsPharmacyByPharmacyEmail(pharmacy.getPharmacyEmail())==false)  {
					
			for(MedicineItem medItem: mMedicineItemRepo.findAll()) {
				ItemStockLevel itemStock = new ItemStockLevel(0, medItem);
				pharmacy.addItemToStock(itemStock);
			}
						
			mPharmacyRepo.save(pharmacy);
			return "Pharmacy Created";
		}
		else {
			return "Pharmacy with same email or same name";
		}
		
	}
//	
	
	
	
	///////////Medicine
	
	
	//New medicine 
	@PostMapping("/newMedicineItemList")
	public void createMedicineList(@RequestBody List<MedicineItem> medicineItems){
		
		mMedicineItemRepo.saveAll(medicineItems);
	}
	
	//
	
	@GetMapping("/medicineItemList")
	public List<MedicineItem> getMedicineItemList() {
		return mMedicineItemRepo.findAll();
	}
	
	

	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	
	
	@PostMapping("/updatePharmacyStockItems")
	public List<ItemStockLevel> updateStock(@RequestBody List<ItemStockLevel> itemStockLevels){
		
		Pharmacy p = mPharmacyRepo.getOne(1);
//		for(ItemStockLevel itemStock : itemStockLevels) {
//			ItemStockLevel itemStockFoundById = mItemStockLevelRepo.getOne(itemStock.getItemStockLevelID());
//			int oldQuantity = itemStockFoundById.getQuantity();
//			itemStockFoundById.setQuantity(oldQuantity+ 2);
//		}
		
		for(ItemStockLevel itemStock : itemStockLevels) {
			p.addItemToStock(itemStock);
		}
		
		mPharmacyRepo.save(p);
		return itemStockLevels;
		
	}
	
	
	
	
	//Load of getters
	
	@GetMapping("/getMedItemById")
	public MedicineItem getMedicineItemById() {
		return mMedicineItemRepo.getOne(1);
		
	}
	
	@GetMapping("/getPrescriptionLineItemById")
	public PrescriptionLineItem getPrescriptionLineItem() {
		return mPrescriptionLineItemRepo.getOne(1);
	}
	
	@GetMapping("/stockLevelItemByID")
	public ItemStockLevel getStockLevelItemByID() {
		return mItemStockLevelRepo.getOne(1);
	}
	
	
	//Return Item stock levels
	
	@GetMapping("/getPharmacyStockItems")
	public List<ItemStockLevel> getItemStockLevelsForPharmacy() {
		Pharmacy p = mPharmacyRepo.getOne(1);
		return mItemStockLevelRepo.findAllByItemStockPharmacy(p);
	}
	
	
	
	//Line Item test get
	@GetMapping("/prescriptionLineItems")
	public List<PrescriptionLineItem> getaPrescriptionLineItems(){
		//Prescription p = mPrescriptionRepo.findById(1).get();
		//return mPrescriptionLineItemRepo.findAllByprescriptionLineItemPrescription(p);
		
		return mPrescriptionLineItemRepo.findAllByprescriptionLineItemPrescriptionPrescriptionID(1);
	}
	
	
}
