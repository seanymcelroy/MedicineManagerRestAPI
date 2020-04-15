package com.example.demo.model;

public class DailyData {
	
	String reportDate;
	int numberOfGlobalCases;
	int numberOfGlobalDeaths;
	int numberOfGlobalRecoveries;
	
	

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
	
	
	
	

}
