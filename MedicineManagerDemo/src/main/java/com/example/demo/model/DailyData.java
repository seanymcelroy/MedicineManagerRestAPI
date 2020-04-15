package com.example.demo.model;

import java.util.List;
import java.util.Map;

public class DailyData {
	
	String reportDate;
	int numberOfGlobalCases;
	int numberOfGlobalDeaths;
	int numberOfGlobalRecoveries;
	List<Map<String, Map<String, Integer>>> countryList;
	
	

	public int getNumberOfGlobalCases() {
		return numberOfGlobalCases;
	}
	public void setNumberOfGlobalCases(int numberOfGlobalCases) {
		this.numberOfGlobalCases = numberOfGlobalCases;
	}
	public int getNumberOfGlobalDeaths() {
		return numberOfGlobalDeaths;
	}
	public void setNumberOfGlobalDeaths(int numberOfGlobalDeaths) {
		this.numberOfGlobalDeaths = numberOfGlobalDeaths;
	}
	public int getNumberOfGlobalRecoveries() {
		return numberOfGlobalRecoveries;
	}
	public void setNumberOfGlobalRecoveries(int numberOfGlobalRecoveries) {
		this.numberOfGlobalRecoveries = numberOfGlobalRecoveries;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public List<Map<String, Map<String, Integer>>> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<Map<String, Map<String, Integer>>> countryList) {
		this.countryList = countryList;
	}

	
	
	
	
	

}
