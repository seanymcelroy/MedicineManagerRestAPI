package com.example.demo.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.AppointmentRepository;
import com.example.demo.dal.PatientRepository;
import com.example.demo.model.Appointment;
import com.example.demo.model.Prescription;
import com.example.demo.model.PrescriptionLineItem;
import com.example.demo.model.user.Patient;
import com.example.demo.model.user.Pharmacy;
import com.example.demo.services.MedicineService;
import com.example.demo.services.PharmacyService;
import com.example.demo.services.PrescriptionComparator;
import com.example.demo.services.PrescriptionService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mobile")
public class MobileAppController {
	
	@Autowired
	PrescriptionService mPrescriptionService;
	
	@Autowired
	PatientRepository mPatientRepo;
	
	@Autowired
	AppointmentRepository mAppointmentRepo;
	
	@Autowired
	PharmacyService mPharmacyService;
	
	@Autowired 
	MedicineService mMedicineItemService;
	
	
	
	
	
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
	
	@GetMapping("/getMyPrescriptionLineItems/{prescriptionID}")
	public List<PrescriptionLineItem> getPrescriptionLineItems(@PathVariable("prescriptionID") int prescriptionID){
		Patient patient = mPatientRepo.getOne(1);
		
		Prescription storedPrescription = mPrescriptionService.getPrescriptionByID(prescriptionID);
		return storedPrescription.getPrescriptionLineItems();
	}
	
//	@GetMapping("/getMyPrescription/{prescriptionID}")
//	public Prescription getPrescriptionById(@PathVariable("prescriptionID") int ) {
//		
//	}
	
	@GetMapping("/availablePharmacies")
	public List<String> getAvailablePharmacies(){
		return mPharmacyService.getListofPharmacyNames();
		
	}
//	
	
	@GetMapping("/availableMedicineNames")
	public List<String> getAvailableMedicines(){
		return mMedicineItemService.fetchAllMedicineNames();
	}
	
	
	@GetMapping("/getMyAppointments")
	public List<Appointment> testGetAllAppointments(){
		Patient p = mPatientRepo.getOne(1);
		return mAppointmentRepo.findByAppointmentPatientPatientID(p.getPatientID());
	}
	
	
	@PostMapping("/createAppointment")
	public void createNewAppointment(@RequestBody Appointment appointment){
		Patient patientUser = mPatientRepo.getOne(1);
		patientUser.addAppointment(appointment);
		mPatientRepo.save(patientUser);
	}
	
	@PostMapping("/newPrescription/{pharmacyName}")
	public void createNewPrescription(@RequestBody Prescription prescription, @PathVariable("pharmacyName") String pharmacyName) {
		
		//Will be replace with Principal when Security added
		Patient patient = mPatientRepo.findById(1).get();
		
		Pharmacy pharmacy = mPharmacyService.findPharmacyByName(pharmacyName);
		
		prescription.setPrescriptionPharmacy(pharmacy);
		patient.addPrescription(prescription);
		mPatientRepo.save(patient);
		
	}
	
	@GetMapping("/allMyLineItems/{months}")
	public List<PrescriptionLineItem> getAllMyLineItemsfromLastXMonths(@PathVariable("months") int months){
		Patient patient = mPatientRepo.getOne(1);
		List<Prescription> allMyPrescriptions = mPrescriptionService.getPatientPrescriptions(patient.getPatientID());
		
	    PrescriptionComparator comparator = new PrescriptionComparator();
	    Collections.sort(allMyPrescriptions, comparator);
	    
	    Long currentTimeinMilliseconds = new Date().getTime();
	    Long oneMonthinMillis = 2592000000L;
	    
	    List<Prescription> prescriptionsInLastXmonths = new ArrayList<>();
	    
	    for(Prescription pre : allMyPrescriptions) {
	    	if(pre.getPrescriptionCreationDate()>currentTimeinMilliseconds-(oneMonthinMillis*months)) {
	    		prescriptionsInLastXmonths.add(pre);
	    	}
	    }
	    
	    List<PrescriptionLineItem> medicineItemsInLastXmonths = new ArrayList<>();
	    
	    for(Prescription pre2 : prescriptionsInLastXmonths) {
	    	medicineItemsInLastXmonths.addAll(pre2.getPrescriptionLineItems());
	    }
		
		return medicineItemsInLastXmonths;
	}
	
	//
}
	
	
	
	
