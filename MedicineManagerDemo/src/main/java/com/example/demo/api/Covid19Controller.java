package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LocationCovidStats;
import com.example.demo.services.Covid19Service;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/covid19")
public class Covid19Controller {
	
	@Autowired
	Covid19Service covid19Service;
	
	@GetMapping("/all")
	public List<LocationCovidStats> getCovidData(){
		return covid19Service.getAllCovidData();
	}

}
