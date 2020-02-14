package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.MedicineRepository;
import com.example.demo.model.Medicine;

@Service
public class MedicineService {

	//private List<Medicine> medicineAvailable = new ArrayList();
	@Autowired
	MedicineRepository medRepo;
	
	public void saveMed(Medicine m) {
		medRepo.save(m);
		
	}
}
