package com.example.demo.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MedicineItem {
	

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	int medicineItemID;
	int cat;
	String barcode;
	String tradename;
	
	
	
	//Constructor
	public MedicineItem() {
		super();
	}
	
	
	

	public int getMedicineItemID() {
		return medicineItemID;
	}
	public void setMedicineItemID(int medicineItemID) {
		this.medicineItemID = medicineItemID;
	}
	public int getCat() {
		return cat;
	}
	public void setCat(int cat) {
		this.cat = cat;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getTradename() {
		return tradename;
	}
	public void setTradename(String tradename) {
		this.tradename = tradename;
	}
	
	
	
	
	

}




















//Full data
//	int category; //int
//	String ipuEANCode;
//	@Id
//	String barcode;
//	int gmsNum; //int
//	String tradeName;
//	String packSize;
//	int packSizeNumber; //int
//	String packSizeUnits;
//	String manufacturer;
//	String agent;
//	double reimbursementPrice; //int
//	double retailPriceRecommended; //double
//	String VAT;
//	String vatChange;
//	String otherChange;
//	String poisonClassification;
//	String productAuthorization;
//	
//	double tradePrice; //think should be double
//	String genericName;
//	String dateBlank;
//	
//	String warningCodesForLabels;	
//	
//	//Text list of comma seperated ingredients
//	String ingredientsListOne;
//	String ingredientsListTwo;
//	String ATCCode;
//	String ATCCodetwo;
//	String Dentist;
//	
//	String counsellingCode;
//	String strength;
//	String formsOfDrug;
//	
//	//Ingredients in each Field
//	String ingredientOne;
//	String ingredientTwo;
//	String ingredientThree;
//	String ingredientFour;
//	String ingredientFive;
//	String ingredientSix;
//	String ingredientSeven;
//	String ingredientEight;
//	String ingredientNine;
//	String ingredientTen;
//	
//	//ATC codes for ingredients
//	String ingredAtcCodeOne;
//	String ingredAtcCodeTwo;
//	String ingredAtcCodeThree;
//	String ingredAtcCodeFour;
//	String ingredAtcCodeFive;
//	String ingredAtcCodeSix;
//	String ingredAtcCodeSeven;
//	String ingredAtcCodeEight;
//	String ingredAtcCodeNine;
//	String ingredAtcCodeTen;
//	
//	//Extra Barcodes
//	String barcodeExtraOne;
//	String barcodeExtraTwo;
//	String barcodeExtraThree;
//	String barcodeExtraFour;
//	String barcodeExtraFive;
//	String barcodeExtraSix;
//	
//	String gmsOne;
//	String eposCat;
//	String eposDept;
//	//String Pharmacovig;
