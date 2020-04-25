//package com.example.demo.services;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.dal.MedicineRepository;
//import com.example.demo.model.Medicine;
//
//@Service
//public class MedicineService {
//
//	//private List<Medicine> medicineAvailable = new ArrayList();
//	@Autowired
//	MedicineRepository medRepo;
//	
//	//Might remove curent medicines in list then compare to current list
//	public void saveListOfMedicine(List<Medicine> medList) {
//		for(Medicine m: medList) {
//			medRepo.save(m);
//		}
//	}
//		
//	public List<Medicine> getMedicines(){
//		return medRepo.findAll();
//	}
//	
//	public Medicine getMedicineByID(String medID){
//		Optional<Medicine> medFoundByID = medRepo.findById(medID);
//		 if (medFoundByID.equals(null)){
//			 return null;
//		 }
//		 
//		 else {
//			 return medFoundByID.get();
//		 }
//	}
//	
//	
//}
