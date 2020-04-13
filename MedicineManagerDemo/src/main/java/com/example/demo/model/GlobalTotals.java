package com.example.demo.model;

public class GlobalTotals {
	
		private int totalConfirmed;
		private int totalRecovered;
		private int totalDeaths;
		
		
		
		public GlobalTotals() {
			super();
		}

		public GlobalTotals(int confirmed, int deathCount, int recovered){
			this.totalConfirmed=confirmed;
			this.totalDeaths=deathCount;
			this.totalRecovered= recovered;
		}

		public int getTotalConfirmed() {
			return totalConfirmed;
		}

		public void setTotalConfirmed(int totalConfirmed) {
			this.totalConfirmed = totalConfirmed;
		}

		public int getTotalRecovered() {
			return totalRecovered;
		}

		public void setTotalRecovered(int totalRecovered) {
			this.totalRecovered = totalRecovered;
		}

		public int getTotalDeaths() {
			return totalDeaths;
		}

		public void setTotalDeaths(int totalDeaths) {
			this.totalDeaths = totalDeaths;
		}
		
		
		
	
}
