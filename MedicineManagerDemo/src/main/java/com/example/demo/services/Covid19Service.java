package com.example.demo.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.model.CountryCovid;
import com.example.demo.model.ProvinceCovid;

@Service
@EnableScheduling
public class Covid19Service {

	private final int numberOfDaysReported = (int) ChronoUnit.DAYS.between(LocalDate.parse("2020-01-22"), LocalDate.now()) ;
	private static String VIRUS_DATA_CONFIRMED_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private static String VIRUS_DATA_DEATHS_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
	private static String VIRUS_DATA_RECOVERED_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";
	
	private List<ProvinceCovid> allStats = new ArrayList<>();
	
	
	public List<ProvinceCovid> getAllCovidData() {
		return allStats;
	}


	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchVirusData() throws IOException, InterruptedException {
		
		
		//Client obj
		HttpClient client = HttpClient.newHttpClient();
		
		//Request confirmed cases
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(VIRUS_DATA_CONFIRMED_URL))
			.build();
		
		//Response
		HttpResponse<String> responseConfirmed = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		StringReader confirmedReader = new StringReader(responseConfirmed.body());
		
		
		///////////////////////////////////////////////////////////////////////////////////
		
		
		//Request Deaths
		HttpRequest requestDeath = HttpRequest.newBuilder()
			.uri(URI.create(VIRUS_DATA_DEATHS_URL))
			.build();
		
		//Response
		HttpResponse<String> responseDeaths = client.send(requestDeath, HttpResponse.BodyHandlers.ofString());
		
		StringReader deathReader = new StringReader(responseDeaths.body());
		
		
		
		///////////////////////////////////////////////////////////////////////////////////
		
		//Request Recoveries
				HttpRequest requestRecovered = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_RECOVERED_URL)).build();
		
		//Response
				HttpResponse<String> responseRecovered = client.send(requestRecovered, HttpResponse.BodyHandlers.ofString());
		
				StringReader recoveredReader = new StringReader(responseRecovered.body());
		
		
		
		//CAll parse csv method
		parseCSV(confirmedReader, deathReader, recoveredReader);
	}
	
	
	//Parse CSV method takes reader plust list
	public void parseCSV(StringReader confirmedR, StringReader deathR, StringReader recoveredR) throws IOException {
		
		
        Iterable<CSVRecord> recordsConfirmed = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(confirmedR);
        Iterable<CSVRecord> recordsDeaths = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(deathR);
        Iterable<CSVRecord> recordsRecovered = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(recoveredR);

        
        
        
        
        //Go through confirmed list
        for (CSVRecord record : recordsConfirmed) {
        	ProvinceCovid singleLocation = new ProvinceCovid();
  	
            singleLocation.setProvince(record.get("Province/State"));
            singleLocation.setCountry(record.get("Country/Region"));
            //singleLocation.setTotalCases7DaysAgo(Integer.parseInt(record.get(record.size() - 8)));
            
            Map<String, Integer> dailyStats = new HashMap<>();
            for (int i=1; i<numberOfDaysReported; i++) {
            	DateTimeFormatter formatters = DateTimeFormatter.ofPattern("M/d/yy");  
            	 LocalDate date = LocalDate.now();
            	 dailyStats.put(date.minusDays(i).format(formatters).toString(), Integer.parseInt(record.get(date.minusDays(i).format(formatters).toString())));
            }
            singleLocation.setDailyCases(dailyStats);
            
            
            //get last column. most up to date record unless its blank
            if(record.get(record.size() - 1).equals("")) {
            	for(int i = 2; i<record.size(); i++) {
            		if(!record.get(record.size()- i).equals("")) {
            			singleLocation.setLatestTotalCases(Integer.parseInt(record.get(record.size() - i)));
            			break;
            		}
            	}
            }else {
            singleLocation.setLatestTotalCases(Integer.parseInt(record.get(record.size() - 1)));
            }
            //singleLocation.setDifferenceInWeek(singleLocation.getLatestTotalCases()-singleLocation.getTotalCases7DaysAgo());
            
            //System.out.println(singleLocation.getDailyCases().toString());
           
            
            allStats.add(singleLocation);
        }
        
        
  
        
        //Go through death list
        for (CSVRecord record : recordsDeaths) {
        	int pos = findIndexInList(record.get("Province/State"), record.get("Country/Region"), allStats);
        	//last column most up to date
        	if(record.get(record.size() - 1).equals("")) {
            	for(int i = 2; i<record.size(); i++) {
            		if(!record.get(record.size()- i).equals("")) {
            			allStats.get(pos).setLatestTotalDeaths(Integer.parseInt(record.get(record.size() - i)));
            			break;
            		}
            	}
            }else {
        	allStats.get(pos).setLatestTotalDeaths(Integer.parseInt(record.get(record.size() - 1)));
            }
        	
        	Map<String, Integer> dailyDStats = new HashMap<>();
            for (int i=1; i<numberOfDaysReported; i++) {
            	DateTimeFormatter formatters = DateTimeFormatter.ofPattern("M/d/yy");  
            	 LocalDate date = LocalDate.now();
            	 dailyDStats.put(date.minusDays(i).format(formatters).toString(), Integer.parseInt(record.get(date.minusDays(i).format(formatters).toString())));
            }
            allStats.get(pos).setDailyDeathCases(dailyDStats);
        }
 
        
        //Go through Recovered list
        for (CSVRecord record : recordsRecovered) {
        	int pos = findIndexInList(record.get(0), record.get("Country/Region"), allStats);
//            System.out.println(pos);

            
        	//latest record for recoveries
            if(pos == -1){
            	continue;
            }
        	if(record.get(record.size() - 1).equals("")) {
            	for(int i = 2; i<record.size(); i++) {
            		if(!record.get(record.size()- i).equals("")) {
            			allStats.get(pos).setLatestTotalRecoveries(Integer.parseInt(record.get(record.size() - i)));
            			break;
            		}
            	}
            }else {
        	allStats.get(pos).setLatestTotalRecoveries(Integer.parseInt(record.get(record.size() - 1)));
            }
        	
        	Map<String, Integer> dailyRStats = new HashMap<>();
        	
            for (int i=1; i<numberOfDaysReported; i++) {
            	DateTimeFormatter formatters = DateTimeFormatter.ofPattern("M/d/yy");  
            	 LocalDate date = LocalDate.now();
            	 dailyRStats.put(date.minusDays(i).format(formatters).toString(), Integer.parseInt(record.get(date.minusDays(i).format(formatters).toString())));
            }
//            System.out.println(dailyRStats.toString());
            allStats.get(pos).setDailyRecoveryCases(dailyRStats);
            //allStats.get(pos).toString();
        }
        
        

        
        
 

    }
	
	
	
	public int findIndexInList(String province, String country, List<ProvinceCovid> locations)
			{
					for (ProvinceCovid loc : locations) {
						
						if (loc.getProvince().equals(province) && loc.getCountry().equals(country)) {
							return locations.indexOf(loc);
						}
						
			        
			    }
					return -1;
			    
			}
	
	public List<CountryCovid> getCountryData() {
		List<ProvinceCovid> allLocations = allStats;
		Set<String> setOfCountries = new HashSet();
		
		//CountryCovid cc = new CountryCovid();
		List<CountryCovid> listOfCountries = new ArrayList();
		
		
		for(ProvinceCovid province: allLocations) {
			if(!setOfCountries.contains(province.getCountry())){
				setOfCountries.add(province.getCountry());
			}
		}
		
		for(String countryName: setOfCountries) {
			listOfCountries.add(new CountryCovid(countryName));
		}
		
		for(ProvinceCovid province: allLocations) {
			for(CountryCovid cc: listOfCountries) {
				if (province.getCountry().equalsIgnoreCase(cc.getCountryName())) {
					
					province.getDailyCases().forEach(
						    (key, value) -> cc.getDailyCountryCases().merge( key, value, Integer::sum)
						);
					
					province.getDailyDeathCases().forEach(
						    (key, value) -> cc.getDailyCountryDeathCases().merge( key, value, Integer::sum)
						);
					
					province.getDailyRecoveryCases().forEach(
						    (key, value) -> cc.getDailyCountryRecoveryCases().merge( key, value, Integer::sum)
						);
				}
			}
		}
		
		return listOfCountries;
		
	
		
			
			
//			HashMap<String, Integer> caseData = new HashMap<>();
////			caseData.put("confirmed", province.getConfimedCasesThisDay(dateStr));
////			caseData.put("deaths", province.getDeathsThisDay(dateStr));
////			caseData.put("recovered", province.getRecoveredCasesThisDay(dateStr));
			
		
	}

	
	
}
