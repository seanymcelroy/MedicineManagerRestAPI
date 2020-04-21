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
import com.example.demo.model.Prescription;
import com.example.demo.model.userAppointment;
import com.example.demo.model.user.Patient;
import com.example.demo.services.MedicineService;
import com.example.demo.services.PatientService;
import com.example.demo.services.PharmacyService;
import com.example.demo.services.PrescriptionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mobile")
public class MobileAppController {
	
	@Autowired
	PrescriptionService mPrescriptionService;
	
	@Autowired
	PharmacyService mPharmcyService;
	
	@Autowired
	PatientService mPatientService;
	
	@GetMapping("/test")
	public String testPrescriptionController() {
		System.out.println("Mobiley app controller mthd test");
		return "Hi android app. from spring";
	}
	
	
	//Prescriptions
	
	@GetMapping("/availablePharmacies")
	public List<String> getAvailablePharmacies(){
		return mPharmcyService.getListofPharmacyNames();
		
	}
	
	@GetMapping("/myprescriptions")
	public List<Prescription> getAllPrescriptionsTest(){
		
		String patientID = "dummyPatientID"; 
		return mPrescriptionService.getPatientPrescriptions(patientID);
	}
	
	
	@PostMapping("prescriptionPost")
	public void postAPrescription(@RequestBody Prescription rx) {
		
		System.out.println(rx.toString());
		
		Prescription prescriptionToSave = new Prescription();
		prescriptionToSave.setPatientOnPrescription(mPatientService.findPatientById(1).get());
		prescriptionToSave.setInstructions(rx.getInstructions());
		prescriptionToSave.setPrescriptionCreationTime(rx.getPrescriptionCreationTime());
		prescriptionToSave.setRxImageURI(rx.getRxImageURI());
		
		mPrescriptionService.addNewPrescription(prescriptionToSave);
	}
	
	
	
	//Appointments
	
	@GetMapping("/myAppointments")
		public List<userAppointment> getAllAppointmentsTest(){
			return mPatientService.getAllAppointments();
			
		}
		
	@PostMapping("/appointment/add")
	public void addAnAppointment(@RequestBody userAppointment appointment){
		 mPatientService.addAppointment(appointment);
	
	}
}
	
	
	
	
