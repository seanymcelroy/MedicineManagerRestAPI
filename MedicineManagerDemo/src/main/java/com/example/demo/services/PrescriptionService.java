package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.util.MessageFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.PrescriptionLineItemRepository;
import com.example.demo.dal.PrescriptionRepository;
import com.example.demo.model.Prescription;
import com.example.demo.model.user.Patient;
import com.example.demo.model.user.Pharmacy;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;


@Service
public class PrescriptionService {
	
	public static final String ACCOUNT_SID = "AC57ab6336707306f367278c36ac7d91dc";
    public static final String AUTH_TOKEN = "c4be11d79037deab65c626cbc7b5a595";
    public static final String TWILIO_NUMBER = "+12025194513";
	
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
	
	public void savePrescription(Prescription p) {
		mPrescriptionRepo.save(p);
	}
	
	
	public void sendPatientTextForPickup(Prescription prescription) {
		
		
		String patientName = prescription.getPatientFirstName();
		String PharmacyName = prescription.getPharmacyName();
		String phoneNumber = prescription.getPrescriptionPatient().getPhoneNumber();
		
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    	
	    	MessageCreator msgCreator = Message.creator(new PhoneNumber("+353868469519"), new PhoneNumber(TWILIO_NUMBER), "Hi "+ patientName + ", Your prescription is ready for pickup in " + PharmacyName + ".");	
	    	
	    	msgCreator.create();
	}
}
