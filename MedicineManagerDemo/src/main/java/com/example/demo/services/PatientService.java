//package com.example.demo.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.dal.AppointmentRepository;
//import com.example.demo.dal.PatientRepository;
//import com.example.demo.model.Appointment;
//import com.example.demo.model.user.Patient;
//import com.example.demo.model.user.Pharmacy;
//
//@Service
//public class PatientService {
//	
//	@Autowired
//	private PatientRepository patientRepo;
//	
//	@Autowired
//	private AppointmentRepository appointmentRepo;
//	
//	
//	public void addNewPatient(Patient p) {
//		patientRepo.save(p);
//	}
//	
//	public boolean createNewPatientUser(Patient p){
//		if (patientRepo.existsByEmail(p.getEmail()) || patientRepo.existsPatientByPhoneNumber(p.getPhoneNumber()) ){
//			return false;
//		}else {
//			//System.out.println(p.toString());
//			patientRepo.save(p);
//			return true;
//		}
//	}
//	
//	public List<Patient> getAllMyPatients(String pharmacyID){
//		
//		//Find Pharmacy by ID. find patients where pharmacy is that retrieved Pharmacy
//		//PharmacyService.FindBYID(pharmacyID)
//		List<Patient> foundPatients = patientRepo.findAll();
//		return foundPatients;
//	}
//	
//	
//	public Optional<Patient> findPatientByEmail(String patEmail){
//		
//		//Find Pharmacy by ID. find patients where pharmacy is that retrieved Pharmacy
//		//PharmacyService.FindBYID(pharmacyID)
//		Optional<Patient> foundPatient = patientRepo.findById(patEmail);
//		return foundPatient;
//	}
//	
//	////////////////
//	//Get patient prescriptions
//	public List<Appointment> getAllAppointments(Patient p){
//		return appointmentRepo.findByPatient(p);
//		
//		
//	}
//	
//	//Get patient prescriptions
//	public void addAppointment(Appointment appointment){
//		appointmentRepo.save(appointment);
//		
//	}
//}
