package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.PharmacyRepository;
import com.example.demo.model.user.Pharmacy;

@Service
public class PharmacyService {
	
	@Autowired
	private PharmacyRepository pharmacyRepository;
	
	public boolean createNewPharmacyUser(Pharmacy p){
		if (pharmacyRepository.existsById(p.getPharmacyEmail()) || pharmacyRepository.existsPharmacyByPharmacyName(p.getPharmacyName()) || pharmacyRepository.existsPharmacyBypsiRegistrationNumber(p.getPsiRegistrationNumber())) {
			return false;
		}else {
			pharmacyRepository.save(p);
			return true;
		}
	}
	
	
	public List<String> getListofPharmacyNames(){
		
		List<Pharmacy> allPharmacies = pharmacyRepository.findAll();
		List<String> pharmacyNamesList = new ArrayList<>();
		
		for(Pharmacy p: allPharmacies) {
			pharmacyNamesList.add(p.getPharmacyName());
		}
		return pharmacyNamesList;
		
	}
	
}
