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

//import com.example.demo.dal.PharmacyRepository;
//import com.example.demo.model.Pharmacy;
//import com.example.demo.services.PharmacyService;

//Rest controller indicates data returned by each method will be written straight into response body. no template rendered
//CrossOrigin allows resource sharing to other servers
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PharmacyController {
	
	
	@GetMapping("/test")
	public String testEndpoint(){
		return "Test endpoint in 'PharmacyController' reached. (permit all)";
	}
	
	@GetMapping("/securedAPI")
	public String testJeff(){
		return "must be logged in to see this.";
	}
	

//	@Autowired
//	PharmacyService pharmacyService;
//	
//	//Get all Pharmacies.
//	//uses jackson to convert object into json
//	@GetMapping("/pharmacies")
//	public List<Pharmacy> getPharmacies(){
//		return pharmacyService.getAllPharms();
//	}
//	
//	
//	//Get a Pharmacy By Email
////	@GetMapping("pharmacy/{email}")
////	public Pharmacy getPharmacyById(@PathVariable("email") String email) {
////		
////		Pharmacy p = pharmacyRepository.findById(email).orElse(null);
////		return p;
////		
////	}
//	
//	//Get pharmacies By name 
//	@GetMapping("pharmacies/{pharmacyName}")
//	public List<Pharmacy> getPharmaciesByName(@PathVariable("pharmacyName") String pharmacyName){
//		
//		List<Pharmacy> ps = pharmacyService.findPharmaciesByName(pharmacyName);
//		return ps;
//	}
//	
//	//Jackson can take json and convert into java objects also.
//	//Add a pharmacy
//	@PostMapping("/pharmacy/add")
//	public String addPharmacy(@RequestBody Pharmacy p){
//		
//		return pharmacyService.SavePharmacyToList(p);
//		
//	}
//	
//	//Update a Pharmacy
//	//Receives a pharmacy object from PUT REQUEST
//	//May identify pharmacy different way. as in pass token then find pharmacy
//	@PutMapping("/pharmacy/update")
//	public String updatePharmacy(@RequestBody Pharmacy PUpdated) {
//		
//		return pharmacyService.updatePharmacyDetails(PUpdated);
//		
//		
//	}
	

}
