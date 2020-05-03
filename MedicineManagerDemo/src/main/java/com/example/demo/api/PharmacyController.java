package com.example.demo.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.ItemStockLevelRepository;
import com.example.demo.dal.PatientRepository;
import com.example.demo.dal.PharmacyRepository;
import com.example.demo.dal.PrescriptionLineItemRepository;
import com.example.demo.model.ItemStockLevel;
import com.example.demo.model.MedicineItem;
import com.example.demo.model.Prescription;
import com.example.demo.model.PrescriptionLineItem;
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
	
	@Autowired 
	PharmacyRepository mPharmacyRepo;
	
	@Autowired
	PatientRepository mPatientRepo;
	
	@Autowired
	PrescriptionLineItemRepository mPrescriptionLineItemRepo;
	
	@Autowired MedicineService mMedicineService;
	
	
	@Autowired PrescriptionService mPrescriptionService;
	
	
	@GetMapping("/test")
	public String pharmacytest() {
		return "Hi from pharmacy test method";
	}
	
	@PostMapping("/updateMedicineStock")
	public void updateMedicineStock(@RequestBody List<ItemStockLevel> updatedStock) {
		Pharmacy p =mPharmacyRepo.getOne(1);
		
		List<Integer> stockItemIds= new ArrayList<Integer>();
		
		for(ItemStockLevel item: updatedStock) {
			stockItemIds.add(item.getItemStockLevelID());
		}
		
//		System.out.println(updatedStock.get(0).getQuantity());
		
		List<ItemStockLevel> mPharmaciesStockItems = mStockRepo.findAllById(stockItemIds);
	
		
		for(ItemStockLevel updateditem: updatedStock) {
			
			ItemStockLevel itemInStorage = mPharmaciesStockItems.stream().
		    filter(ItemStockLevel -> ItemStockLevel.getItemStockLevelID()==(updateditem.getItemStockLevelID())).
		    findFirst().get();
			
			itemInStorage.setQuantity(updateditem.getQuantity());
		}
		
		mStockRepo.saveAll(mPharmaciesStockItems);
		
		
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
	
	
	
	@GetMapping("/getPatientDetailsById/{patientID}")
	public Patient getPatientDetailsByPatient(@PathVariable("patientID") int patientID) {
		Pharmacy p =mPharmacyRepo.getOne(1);
			
		if (mPrescriptionService.hasPharmacyAccessToPatient(p.getPharmacyID() ,patientID)==true) {
			return mPatientRepo.getOne(patientID);
		}
		return null;
		
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
	
	@GetMapping("/getPrescriptionLineItems/{prescriptionID}")
	public List<PrescriptionLineItem> getLineItemsOnPrescription(@PathVariable("prescriptionID") int prescriptionId){
		Pharmacy pharm = mPharmacyRepo.getOne(1);
		
		return mPrescriptionLineItemRepo.findAllByprescriptionLineItemPrescriptionPrescriptionID(prescriptionId);
		
	}
	
	//fetch available medicine
	@GetMapping("/getAvailableMedicine")
	public List<MedicineItem> getAvailableMedicine(){
		Pharmacy p = mPharmacyRepo.getOne(1);
		
		return mMedicineService.getPharmacyAvailableMedicine(p);
		
	}
	
	
	
	@GetMapping("/prescriptioneditable/{prescriptionID}")
	public boolean isPrescriptionEditable(@PathVariable("prescriptionID") int prescriptionID) {
		Pharmacy p = mPharmacyRepo.getOne(1);
		Prescription prescriptionInQuestion = mPrescriptionService.getPrescriptionByID(prescriptionID);
		
		if(prescriptionInQuestion.getPrescriptionPharmacy().getPharmacyID()!= p.getPharmacyID()) {
			return false;
		}
		
		if(prescriptionInQuestion.getPrescriptionStatus().equalsIgnoreCase("fulfilled") || prescriptionInQuestion.getPrescriptionStatus().equalsIgnoreCase("cancelled")) {
			return false;
		}
		
		return true;
		
	}
	
	@PostMapping("/updatePrescription")
	public void updatePrescription(@RequestBody Prescription updatePrescription) {
		Pharmacy pharmacy = mPharmacyRepo.getOne(1);
		Prescription prescriptionStored=mPrescriptionService.getPrescriptionByID(updatePrescription.getPrescriptionID());
		
		prescriptionStored.setPrescriptionStatus(updatePrescription.getPrescriptionStatus());
		prescriptionStored.setDoctor(updatePrescription.getDoctor());
		prescriptionStored.setPrescriptionFulfilmentDate(updatePrescription.getPrescriptionFulfilmentDate());
		
		mPrescriptionService.savePrescription(prescriptionStored);
		
		if (updatePrescription.getPrescriptionStatus().equalsIgnoreCase("fulfilled")){
			System.out.println("hi");
			System.out.println(prescriptionStored.getPrescriptionLineItems().size());
			
			mPrescriptionService.adjustStock(prescriptionStored, pharmacy);
		}
		
		if (updatePrescription.getPrescriptionStatus().equalsIgnoreCase("ready")){
			//Twillio
			mPrescriptionService.sendPatientTextForPickup(prescriptionStored);
		}
		
		if (updatePrescription.getPrescriptionStatus().equalsIgnoreCase("cancelled")){
			//Twillio
			mPrescriptionService.sendPatientTextCancelled(prescriptionStored);
		}

		//if cancelled
		
	}
	
	@PostMapping("/updatePrescriptionLineItems/{PrescriptionID}")
	public void updatePrescriptionRemoveLineItems(@RequestBody List<PrescriptionLineItem> lineItemsOnPrescription, @PathVariable("PrescriptionID") int prescriptionID) {
		
		Prescription prescriptionStored=mPrescriptionService.getPrescriptionByID(prescriptionID);
				
		List<PrescriptionLineItem> itemsToRemove = new ArrayList<>();
		for (PrescriptionLineItem lineItem : prescriptionStored.getPrescriptionLineItems()) {
			itemsToRemove.add(lineItem);
		}

		for(PrescriptionLineItem lineItem : itemsToRemove) {
			prescriptionStored.removePrescriptionLineItem(lineItem);
		}
		
		mPrescriptionService.savePrescription(prescriptionStored);
		
	
		
		updateAddLineItems(lineItemsOnPrescription, prescriptionID);
		
		
		
	}
	
	public void updateAddLineItems(List<PrescriptionLineItem> lineItemsOnPrescription, int prescriptionID){
			Prescription prescriptionStored2=mPrescriptionService.getPrescriptionByID(prescriptionID);
		
		for(PrescriptionLineItem lineItem : lineItemsOnPrescription) {
			int medicineID = lineItem.getLineItemMedicineID();
			String lineItemInstructions = lineItem.getPrescriptionLineItemInstructions();
			int quantityOfMedicine = lineItem.getPrescriptionLineItemQty();
			
			
			PrescriptionLineItem lineItemToBeAdded = new PrescriptionLineItem();
			
			lineItemToBeAdded.setLineItemMedicine(mMedicineService.getMedicineItemByID(medicineID));
			lineItemToBeAdded.setPrescriptionLineItemInstructions(lineItemInstructions);
			lineItemToBeAdded.setPrescriptionLineItemQty(quantityOfMedicine);
			
			prescriptionStored2.addPrescriptionLineItem(lineItemToBeAdded);
		}
		
			mPrescriptionService.savePrescription(prescriptionStored2);
	}
	
	
	@GetMapping("/CheckLineItemStock/{medicineID}/{qtyToBeRemoved}")
	public boolean enoughMedicineStock(@PathVariable("medicineID") int medicineID, @PathVariable("qtyToBeRemoved") int qtyToBeRemoved) {
		Pharmacy pharmacy = mPharmacyRepo.getOne(1);
		
		ItemStockLevel itemStock = mStockRepo.findByItemStockMedicineMedicineItemIDAndItemStockPharmacy(medicineID, pharmacy);
		
		if(itemStock.getQuantity()-qtyToBeRemoved < 0) {
			return false;
		}else {
			return true;
		}
		
	}
}
