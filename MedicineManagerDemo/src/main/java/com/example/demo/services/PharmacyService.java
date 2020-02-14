//package com.example.demo.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.dal.PharmacyRepository;
//import com.example.demo.model.Pharmacy;
//
//@Service
//public class PharmacyService {
//	
//	@Autowired
//	private PharmacyRepository pharmacyRepository;
//	
//	public Optional<Pharmacy> getPharmacy(int pid) {
//		return pharmacyRepository.findById(pid);
//		
//	}
//
//	public List<Pharmacy> getAllPharms(){
//		return pharmacyRepository.findAll();	
//	}
//	
//	public List<Pharmacy> findPharmaciesByName(String pharmacyName){
//		return pharmacyRepository.findByPharmacyName(pharmacyName);
//	}
//	
//	public String SavePharmacyToList(Pharmacy p) {
//		//if(pharmacyRepository.findById(p.getPharmacyEmail()) ) {
//		pharmacyRepository.save(p);
//		return "Pharmacy successcful created";
//	}
//	
//	public String updatePharmacyDetails(Pharmacy updatedPharmacy) {
//		pharmacyRepository.save(updatedPharmacy);
//		return "Pharmacy Updated";
//	}
//}
