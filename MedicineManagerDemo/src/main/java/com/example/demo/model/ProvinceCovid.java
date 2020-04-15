package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class ProvinceCovid {

	    private String province;
	    private String country;
	    //private int differenceInWeek;
	    private int latestTotalCases;
	    
	    private Map<String, Integer> dailyCases = new HashMap<String, Integer>();
	    private Map<String, Integer> dailyDeathCases = new HashMap<String, Integer>();
	    private Map<String, Integer> dailyRecoveryCases = new HashMap<String, Integer>();

		

		private int latestTotalDeaths;
	    private int latestTotalRecoveries;


	    public String getProvince() {
	        return province;
	    }

	    public void setProvince(String province) {
	        this.province = province;
	    }

	    public String getCountry() {
	        return country;
	    }

	    public void setCountry(String country) {
	        this.country = country;
	    }

	    public int getLatestTotalCases() {
	        return latestTotalCases;
	    }

	    public void setLatestTotalCases(int latestTotalCases) {
	        this.latestTotalCases = latestTotalCases;
	    }

	    public int getLatestTotalDeaths() {
	        return latestTotalDeaths;
	    }

	    public void setLatestTotalDeaths(int latestTotalDeaths) {
	        this.latestTotalDeaths = latestTotalDeaths;
	    }

	    public int getLatestTotalRecoveries() {
	        return latestTotalRecoveries;
	    }

	    public void setLatestTotalRecoveries(int latestTotalRecoveries) {
	        this.latestTotalRecoveries = latestTotalRecoveries;
	    }
	    
	    public Map<String, Integer> getDailyCases() {
			return dailyCases;
		}

		public void setDailyCases(Map<String, Integer> dailyCases) {
			this.dailyCases = dailyCases;
		}

		public Map<String, Integer> getDailyDeathCases() {
			return dailyDeathCases;
		}

		public void setDailyDeathCases(Map<String, Integer> dailyDeathCases) {
			this.dailyDeathCases = dailyDeathCases;
		}

		
		
		public Map<String, Integer> getDailyRecoveryCases() {
			return dailyRecoveryCases;
		}

		public void setDailyRecoveryCases(Map<String, Integer> dailyRecoveryCases) {
			this.dailyRecoveryCases = dailyRecoveryCases;
		}

		@Override
		public String toString() {
			return "ProvinceCovid [province=" + province + ", country=" + country + ", latestTotalCases="
					+ latestTotalCases + ", dailyCases=" + dailyCases + ", dailyDeathCases=" + dailyDeathCases
					+ ", dailyRecoveryCases=" + dailyRecoveryCases + ", latestTotalDeaths=" + latestTotalDeaths
					+ ", latestTotalRecoveries=" + latestTotalRecoveries + "]";
		}




	    
	    




	    
		
		
		
	
}
