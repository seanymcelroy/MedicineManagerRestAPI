package com.example.demo.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CountryCovid;
import com.example.demo.model.DailyData;
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
	
	

	
	
	@GetMapping("/GlobalDailyNumbers")
	public List<DailyData> DailyCovidData(){
		
		Map<String, Integer> dailyGlobalCases = new HashMap<>();
		Map<String, Integer> dailyGlobalDeaths = new HashMap<>();
		Map<String, Integer> dailyGlobalRecoveries = new HashMap<>();	
		
				
				
		for(ProvinceCovid covProv: covid19Service.getAllCovidData()) {
			
			
			covProv.getDailyCases().forEach(
				    (key, value) -> dailyGlobalCases.merge( key, value, Integer::sum)
				);
			
			covProv.getDailyDeathCases().forEach(
				    (key, value) -> dailyGlobalDeaths.merge( key, value, Integer::sum)
				);
			
			covProv.getDailyRecoveryCases().forEach(
				    (key, value) -> dailyGlobalRecoveries.merge( key, value, Integer::sum)
				);
	
		}
		
		
		
		List<DailyData> dailyDataList = new ArrayList<>();
		
		for (int i=1; i<(int) ChronoUnit.DAYS.between(LocalDate.parse("2020-01-22"), LocalDate.now()); i++) {
        	DateTimeFormatter formatters = DateTimeFormatter.ofPattern("M/d/yy"); 
        	DateTimeFormatter formatForClient = DateTimeFormatter.ofPattern("dd/MM/yy"); 
        	 LocalDate date = LocalDate.now();
        	 
        	 DailyData dd = new DailyData();
        	     		
     		dd.setReportDate(date.minusDays(i).format(formatForClient));
     		dd.setNumberOfGlobalCases(dailyGlobalCases.get(date.minusDays(i).format(formatters)));
     		dd.setNumberOfGlobalDeaths(dailyGlobalDeaths.get(date.minusDays(i).format(formatters)));
     		dd.setNumberOfGlobalRecoveries(dailyGlobalRecoveries.get(date.minusDays(i).format(formatters)));
     		//dd.setCountryList(covid19Service.getCountryData());
     		dailyDataList.add(dd);	
		}
		
		//myLis.add(RealMapOMaps);
		return dailyDataList;
	}
	
	
	@GetMapping("/countryDailyStats")
	public List<CountryCovid> getIt() {
		return covid19Service.getCountryData();
	}

	

}
