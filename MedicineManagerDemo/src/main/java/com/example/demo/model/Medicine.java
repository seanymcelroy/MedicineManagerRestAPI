package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//This classes fields should be populated by IPU product file csv.

@Entity
public class Medicine {
	
	@Id
	String manuFacturerBarcode;
	
	
	String TradeName;
	
	//Text list of comma seperated ingredients
	String ingredientsListOne;
	
	
	
	public String getTradeName() {
		return TradeName;
	}
	public void setTradeName(String tradeName) {
		TradeName = tradeName;
	}
	public String getManuFacturerBarcode() {
		return manuFacturerBarcode;
	}
	public void setManuFacturerBarcode(String manuFacturerBarcode) {
		this.manuFacturerBarcode = manuFacturerBarcode;
	}
	public String getIngredientsListOne() {
		return ingredientsListOne;
	}
	public void setIngredientsListOne(String ingredientsListOne) {
		this.ingredientsListOne = ingredientsListOne;
	}
	
	
	

}
