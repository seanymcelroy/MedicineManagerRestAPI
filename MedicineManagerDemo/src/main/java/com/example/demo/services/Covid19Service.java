package com.example.demo.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.model.LocationCovidStats;

@Service
@EnableScheduling
public class Covid19Service {

	private static String VIRUS_DATA_CONFIRMED_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private static String VIRUS_DATA_DEATHS_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
	private static String VIRUS_DATA_RECOVERED_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";
	
	private List<LocationCovidStats> allStats = new ArrayList<>();
	
	
	public List<LocationCovidStats> getAllCovidData() {
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
        	LocationCovidStats singleLocation = new LocationCovidStats();
  	
            singleLocation.setProvince(record.get("Province/State"));
            singleLocation.setCountry(record.get("Country/Region"));
            singleLocation.setTotalCases7DaysAgo(Integer.parseInt(record.get(record.size() - 8)));
            
            
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
            singleLocation.setDifferenceInWeek(singleLocation.getLatestTotalCases()-singleLocation.getTotalCases7DaysAgo());
            
//            System.out.println(singleLocation.getProvince() + "\t" + singleLocation.getCountry() + "\t" + singleLocation.getLatestTotalCases());
            
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
        }
 
        
        //Go through Recovered list
        for (CSVRecord record : recordsRecovered) {
        	int pos = findIndexInList(record.get(0), record.get("Country/Region"), allStats);
//            System.out.println(pos);
//            System.out.println(record.get("Country/Region"));
            
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
        }

        
 

    }
	
	
	
	public int findIndexInList(String province, String country, List<LocationCovidStats> locations)
			{
					for (LocationCovidStats loc : locations) {
						
						if (loc.getProvince().equals(province) && loc.getCountry().equals(country)) {
							return locations.indexOf(loc);
						}
						
			        
			    }
					return -1;
			    
			}
	

	
}
