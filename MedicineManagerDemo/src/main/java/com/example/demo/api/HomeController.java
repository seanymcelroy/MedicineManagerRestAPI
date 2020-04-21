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

import com.example.demo.model.user.Pharmacy;
import com.example.demo.services.PharmacyService;

//import com.example.demo.dal.PharmacyRepository;
//import com.example.demo.model.Pharmacy;
//import com.example.demo.services.PharmacyService;

//Rest controller indicates data returned by each method will be written straight into response body. no template rendered
//CrossOrigin allows resource sharing to other servers
@RestController
@CrossOrigin(origins="*")
public class HomeController {
	
	
	@GetMapping("/test")
	public String testEndpoint(){
		return "Test endpoint in Home Controller reached. (permit all)";
	}
	

	@Autowired
	PharmacyService pharmacyService;

	
	@PostMapping("/newPharm")
	public String createNewPharmacy(@RequestBody Pharmacy pharmacyNue) {
		if (pharmacyService.createNewPharmacyUser(pharmacyNue)==true) {
			return "Pharmacy Created";
		}
		else {
			return "Pharmacy with same email or same name or same psiNumber exists";
		}
		
	}
	

}
