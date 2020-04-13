package com.example.demo.model;

public class ProvinceCovid {

	    private String province;
	    private String country;
	    private int latestTotalCases;
	    private int totalCases7DaysAgo;
	    private int differenceInWeek;


	    public int getDifferenceInWeek() {
			return differenceInWeek;
		}

		public void setDifferenceInWeek(int differenceInWeek) {
			this.differenceInWeek = differenceInWeek;
		}

		public int getTotalCases7DaysAgo() {
			return totalCases7DaysAgo;
		}

		public void setTotalCases7DaysAgo(int totalCases7DaysAgo) {
			this.totalCases7DaysAgo = totalCases7DaysAgo;
		}

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

		@Override
		public String toString() {
			return "LocationCovidStats [province=" + province + ", country=" + country + ", latestTotalCases="
					+ latestTotalCases + ", latestTotalDeaths=" + latestTotalDeaths + ", latestTotalRecoveries="
					+ latestTotalRecoveries + "]";
		}


	    
	
}
