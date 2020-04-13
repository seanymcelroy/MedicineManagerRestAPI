package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GlobalTotals;
import com.example.demo.model.ProvinceCovid;
import com.example.demo.services.Covid19Service;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/covid19")
public class Covid19Controller {
	
	@Autowired
	Covid19Service covid19Service;
	
	@GetMapping("/covyTest")
	public String test() {
		return "reach covid19 controller";
	}
	
	@GetMapping("/all")
	public List<ProvinceCovid> getCovidData(){
		return covid19Service.getAllCovidData();
	}
	
	@GetMapping("/globalTotals")
	public GlobalTotals getCovidTotals(){
		
		int confirmed = 0;
		int deaths = 0;
		int recovered = 0;
		
		
		
		
				
		for(ProvinceCovid covProv: covid19Service.getAllCovidData()) {
			
			confirmed += covProv.getLatestTotalCases();
			deaths += covProv.getLatestTotalDeaths();
			recovered += covProv.getLatestTotalRecoveries();
	
		}
		
		return new GlobalTotals(confirmed, deaths, recovered);
	}

	

}
