package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.PrescriptionLineItemRepository;
import com.example.demo.dal.PrescriptionRepository;
import com.example.demo.model.Prescription;
import com.example.demo.model.user.Pharmacy;

@Service
public class PrescriptionService {
	
	@Autowired
	PrescriptionRepository mPrescriptionRepo;
	
	
	public List<Prescription> getPharmacyPrescriptions(Pharmacy p){
		
		return mPrescriptionRepo.findAllByPrescriptionPharmacyPharmacyID(p.getPharmacyID());
	}
	
	
	
	public List<Prescription> getPatientPrescriptions(int patientID){
		return mPrescriptionRepo.findAllByPrescriptionPatientPatientID(patientID);
	}
	
	
	
	//Can pharmacy x see patient y. only if patient y has sent prescription to pharmacy x
	public boolean hasPharmacyAccessToPatient(int pharmacyID, int patientID) {
		 List<Prescription> patientAllPrescriptions = getPatientPrescriptions(patientID);
		for(Prescription patPrescriptions: patientAllPrescriptions) {
			if(patPrescriptions.getPrescriptionPharmacy().getPharmacyID() == pharmacyID) {
				return true;
			}
		}
		return false;
	}
	
	
	public Prescription getPrescriptionByID(int prescriptionID) {
		return mPrescriptionRepo.findById(prescriptionID).get();
	}
}
