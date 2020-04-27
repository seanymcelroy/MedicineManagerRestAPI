package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MedicineItem;
import com.example.demo.services.MedicineService;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "*")
public class AdminController {
	
	
	@Autowired
	MedicineService mMedService;
	
	@GetMapping("/test")
	public String adminTest() {
		return "test from admin";
	}
	
	
	@PostMapping("/updateMedList")
	public void updateProductFile(@RequestBody List<MedicineItem> nuevoMedList){
		
		mMedService.updateMedicineList(nuevoMedList);
		
	}
	
	@GetMapping("/retrieveAllMedItems")
	public List<MedicineItem> getAllMedItems(){
		
		return mMedService.fetchAllMedItemList();
		
	}

}
