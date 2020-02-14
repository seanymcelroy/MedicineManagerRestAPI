package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Medicine;
import com.example.demo.services.MedicineService;

//import com.example.demo.dal.PharmacyRepository;
//import com.example.demo.model.Pharmacy;
//import com.example.demo.services.PharmacyService;

//Rest controller indicates data returned by each method will be written straight into response body. no template rendered
//CrossOrigin allows resource sharing to other servers
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/medicine")
public class MedicineController {
	
	@Autowired
	MedicineService medService;
	
	
	@GetMapping("/testmed")
	public String testEndpoint(){
		return "medicine test ep reached";
	}
	
	
	@PostMapping("/addMeds")
	public String addMedicine(@RequestBody Medicine m){
		
		medService.saveMed(m);
		return "pray this works";
		
	}
	
	

}
