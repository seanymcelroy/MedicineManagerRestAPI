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
}
