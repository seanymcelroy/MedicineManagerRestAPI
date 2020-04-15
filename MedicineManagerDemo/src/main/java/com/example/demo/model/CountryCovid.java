package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class CountryCovid {

	    private String countryName;
	    
	    private Map<String, Integer> dailyCountryCases = new HashMap<String, Integer>();
	    private Map<String, Integer> dailyCountryDeathCases = new HashMap<String, Integer>();
	    private Map<String, Integer> dailyCountryRecoveryCases = new HashMap<String, Integer>();
	       
	    
	    
		public CountryCovid(String countryName) {
			super();
			this.countryName = countryName;
		}
		
		public String getCountryName() {
			return countryName;
		}
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}
		public Map<String, Integer> getDailyCountryCases() {
			return dailyCountryCases;
		}
		public void setDailyCountryCases(Map<String, Integer> dailyCountryCases) {
			this.dailyCountryCases = dailyCountryCases;
		}
		public Map<String, Integer> getDailyCountryDeathCases() {
			return dailyCountryDeathCases;
		}
		public void setDailyCountryDeathCases(Map<String, Integer> dailyCountryDeathCases) {
			this.dailyCountryDeathCases = dailyCountryDeathCases;
		}
		public Map<String, Integer> getDailyCountryRecoveryCases() {
			return dailyCountryRecoveryCases;
		}
		public void setDailyCountryRecoveryCases(Map<String, Integer> dailyCountryRecoveryCases) {
			this.dailyCountryRecoveryCases = dailyCountryRecoveryCases;
		}

		@Override
		public String toString() {
			return "CountryCovid [countryName=" + countryName + ", dailyCountryCases=" + dailyCountryCases
					+ ", dailyCountryDeathCases=" + dailyCountryDeathCases + ", dailyCountryRecoveryCases="
					+ dailyCountryRecoveryCases + "]";
		}


	   
	    




	    
		
		
		
	
}
