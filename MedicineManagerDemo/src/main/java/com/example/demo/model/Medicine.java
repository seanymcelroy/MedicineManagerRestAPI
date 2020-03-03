package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.demo.model.user.UserPharmacy;

//This classes fields should be populated by IPU product file csv.

@Entity
public class Medicine {
	


	int category; //int
	String ipuEANCode;
	@Id
	String barcode;
	int gmsNum; //int
	String tradeName;
	String packSize;
	int packSizeNumber; //int
	String packSizeUnits;
	String manufacturer;
	String agent;
	double reimbursementPrice; //int
	double retailPriceRecommended; //double
	String VAT;
	String vatChange;
	String otherChange;
	String poisonClassification;
	String productAuthorization;
	
	double tradePrice; //think should be double
	String genericName;
	String dateBlank;
	
	String warningCodesForLabels;	
	
	//Text list of comma seperated ingredients
	String ingredientsListOne;
	String ingredientsListTwo;
	String ATCCode;
	String ATCCodetwo;
	String Dentist;
	
	String counsellingCode;
	String strength;
	String formsOfDrug;
	
	//Ingredients in each Field
	String ingredientOne;
	String ingredientTwo;
	String ingredientThree;
	String ingredientFour;
	String ingredientFive;
	String ingredientSix;
	String ingredientSeven;
	String ingredientEight;
	String ingredientNine;
	String ingredientTen;
	
	//ATC codes for ingredients
	String ingredAtcCodeOne;
	String ingredAtcCodeTwo;
	String ingredAtcCodeThree;
	String ingredAtcCodeFour;
	String ingredAtcCodeFive;
	String ingredAtcCodeSix;
	String ingredAtcCodeSeven;
	String ingredAtcCodeEight;
	String ingredAtcCodeNine;
	String ingredAtcCodeTen;
	
	//Extra Barcodes
	String barcodeExtraOne;
	String barcodeExtraTwo;
	String barcodeExtraThree;
	String barcodeExtraFour;
	String barcodeExtraFive;
	String barcodeExtraSix;
	
	String gmsOne;
	String eposCat;
	String eposDept;
	//String Pharmacovig;// Dont uncomment
	
//	@ManyToOne
//	UserPharmacy pharmy;
	

	public Medicine() {}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getIpuEANCode() {
		return ipuEANCode;
	}

	public void setIpuEANCode(String ipuEANCode) {
		this.ipuEANCode = ipuEANCode;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public int getGmsNum() {
		return gmsNum;
	}

	public void setGmsNum(int gmsNum) {
		this.gmsNum = gmsNum;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getPackSize() {
		return packSize;
	}

	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}

	public int getPackSizeNumber() {
		return packSizeNumber;
	}

	public void setPackSizeNumber(int packSizeNumber) {
		this.packSizeNumber = packSizeNumber;
	}

	public String getPackSizeUnits() {
		return packSizeUnits;
	}

	public void setPackSizeUnits(String packSizeUnits) {
		this.packSizeUnits = packSizeUnits;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public double getReimbursementPrice() {
		return reimbursementPrice;
	}

	public void setReimbursementPrice(double reimbursementPrice) {
		this.reimbursementPrice = reimbursementPrice;
	}

	public double getRetailPriceRecommended() {
		return retailPriceRecommended;
	}

	public void setRetailPriceRecommended(double retailPriceRecommended) {
		this.retailPriceRecommended = retailPriceRecommended;
	}

	public String getVAT() {
		return VAT;
	}

	public void setVAT(String vAT) {
		VAT = vAT;
	}

	public String getVatChange() {
		return vatChange;
	}

	public void setVatChange(String vatChange) {
		this.vatChange = vatChange;
	}

	public String getOtherChange() {
		return otherChange;
	}

	public void setOtherChange(String otherChange) {
		this.otherChange = otherChange;
	}

	public String getPoisonClassification() {
		return poisonClassification;
	}

	public void setPoisonClassification(String poisonClassification) {
		this.poisonClassification = poisonClassification;
	}

	public String getProductAuthorization() {
		return productAuthorization;
	}

	public void setProductAuthorization(String productAuthorization) {
		this.productAuthorization = productAuthorization;
	}

	public double getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(double tradePrice) {
		this.tradePrice = tradePrice;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getDateBlank() {
		return dateBlank;
	}

	public void setDateBlank(String dateBlank) {
		this.dateBlank = dateBlank;
	}

	public String getWarningCodesForLabels() {
		return warningCodesForLabels;
	}

	public void setWarningCodesForLabels(String warningCodesForLabels) {
		this.warningCodesForLabels = warningCodesForLabels;
	}

	public String getIngredientsListOne() {
		return ingredientsListOne;
	}

	public void setIngredientsListOne(String ingredientsListOne) {
		this.ingredientsListOne = ingredientsListOne;
	}

	public String getIngredientsListTwo() {
		return ingredientsListTwo;
	}

	public void setIngredientsListTwo(String ingredientsListTwo) {
		this.ingredientsListTwo = ingredientsListTwo;
	}

	public String getATCCode() {
		return ATCCode;
	}

	public void setATCCode(String aTCCode) {
		ATCCode = aTCCode;
	}

	public String getATCCodetwo() {
		return ATCCodetwo;
	}

	public void setATCCodetwo(String aTCCodetwo) {
		ATCCodetwo = aTCCodetwo;
	}

	public String getDentist() {
		return Dentist;
	}

	public void setDentist(String dentist) {
		Dentist = dentist;
	}

	public String getCounsellingCode() {
		return counsellingCode;
	}

	public void setCounsellingCode(String counsellingCode) {
		this.counsellingCode = counsellingCode;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getFormsOfDrug() {
		return formsOfDrug;
	}

	public void setFormsOfDrug(String formsOfDrug) {
		this.formsOfDrug = formsOfDrug;
	}

	public String getIngredientOne() {
		return ingredientOne;
	}

	public void setIngredientOne(String ingredientOne) {
		this.ingredientOne = ingredientOne;
	}

	public String getIngredientTwo() {
		return ingredientTwo;
	}

	public void setIngredientTwo(String ingredientTwo) {
		this.ingredientTwo = ingredientTwo;
	}

	public String getIngredientThree() {
		return ingredientThree;
	}

	public void setIngredientThree(String ingredientThree) {
		this.ingredientThree = ingredientThree;
	}

	public String getIngredientFour() {
		return ingredientFour;
	}

	public void setIngredientFour(String ingredientFour) {
		this.ingredientFour = ingredientFour;
	}

	public String getIngredientFive() {
		return ingredientFive;
	}

	public void setIngredientFive(String ingredientFive) {
		this.ingredientFive = ingredientFive;
	}

	public String getIngredientSix() {
		return ingredientSix;
	}

	public void setIngredientSix(String ingredientSix) {
		this.ingredientSix = ingredientSix;
	}

	public String getIngredientSeven() {
		return ingredientSeven;
	}

	public void setIngredientSeven(String ingredientSeven) {
		this.ingredientSeven = ingredientSeven;
	}

	public String getIngredientEight() {
		return ingredientEight;
	}

	public void setIngredientEight(String ingredientEight) {
		this.ingredientEight = ingredientEight;
	}

	public String getIngredientNine() {
		return ingredientNine;
	}

	public void setIngredientNine(String ingredientNine) {
		this.ingredientNine = ingredientNine;
	}

	public String getIngredientTen() {
		return ingredientTen;
	}

	public void setIngredientTen(String ingredientTen) {
		this.ingredientTen = ingredientTen;
	}

	public String getIngredAtcCodeOne() {
		return ingredAtcCodeOne;
	}

	public void setIngredAtcCodeOne(String ingredAtcCodeOne) {
		this.ingredAtcCodeOne = ingredAtcCodeOne;
	}

	public String getIngredAtcCodeTwo() {
		return ingredAtcCodeTwo;
	}

	public void setIngredAtcCodeTwo(String ingredAtcCodeTwo) {
		this.ingredAtcCodeTwo = ingredAtcCodeTwo;
	}

	public String getIngredAtcCodeThree() {
		return ingredAtcCodeThree;
	}

	public void setIngredAtcCodeThree(String ingredAtcCodeThree) {
		this.ingredAtcCodeThree = ingredAtcCodeThree;
	}

	public String getIngredAtcCodeFour() {
		return ingredAtcCodeFour;
	}

	public void setIngredAtcCodeFour(String ingredAtcCodeFour) {
		this.ingredAtcCodeFour = ingredAtcCodeFour;
	}

	public String getIngredAtcCodeFive() {
		return ingredAtcCodeFive;
	}

	public void setIngredAtcCodeFive(String ingredAtcCodeFive) {
		this.ingredAtcCodeFive = ingredAtcCodeFive;
	}

	public String getIngredAtcCodeSix() {
		return ingredAtcCodeSix;
	}

	public void setIngredAtcCodeSix(String ingredAtcCodeSix) {
		this.ingredAtcCodeSix = ingredAtcCodeSix;
	}

	public String getIngredAtcCodeSeven() {
		return ingredAtcCodeSeven;
	}

	public void setIngredAtcCodeSeven(String ingredAtcCodeSeven) {
		this.ingredAtcCodeSeven = ingredAtcCodeSeven;
	}

	public String getIngredAtcCodeEight() {
		return ingredAtcCodeEight;
	}

	public void setIngredAtcCodeEight(String ingredAtcCodeEight) {
		this.ingredAtcCodeEight = ingredAtcCodeEight;
	}

	public String getIngredAtcCodeNine() {
		return ingredAtcCodeNine;
	}

	public void setIngredAtcCodeNine(String ingredAtcCodeNine) {
		this.ingredAtcCodeNine = ingredAtcCodeNine;
	}

	public String getIngredAtcCodeTen() {
		return ingredAtcCodeTen;
	}

	public void setIngredAtcCodeTen(String ingredAtcCodeTen) {
		this.ingredAtcCodeTen = ingredAtcCodeTen;
	}

	public String getBarcodeExtraOne() {
		return barcodeExtraOne;
	}

	public void setBarcodeExtraOne(String barcodeExtraOne) {
		this.barcodeExtraOne = barcodeExtraOne;
	}

	public String getBarcodeExtraTwo() {
		return barcodeExtraTwo;
	}

	public void setBarcodeExtraTwo(String barcodeExtraTwo) {
		this.barcodeExtraTwo = barcodeExtraTwo;
	}

	public String getBarcodeExtraThree() {
		return barcodeExtraThree;
	}

	public void setBarcodeExtraThree(String barcodeExtraThree) {
		this.barcodeExtraThree = barcodeExtraThree;
	}

	public String getBarcodeExtraFour() {
		return barcodeExtraFour;
	}

	public void setBarcodeExtraFour(String barcodeExtraFour) {
		this.barcodeExtraFour = barcodeExtraFour;
	}

	public String getBarcodeExtraFive() {
		return barcodeExtraFive;
	}

	public void setBarcodeExtraFive(String barcodeExtraFive) {
		this.barcodeExtraFive = barcodeExtraFive;
	}

	public String getBarcodeExtraSix() {
		return barcodeExtraSix;
	}

	public void setBarcodeExtraSix(String barcodeExtraSix) {
		this.barcodeExtraSix = barcodeExtraSix;
	}

	public String getGmsOne() {
		return gmsOne;
	}

	public void setGmsOne(String gmsOne) {
		this.gmsOne = gmsOne;
	}

	public String getEposCat() {
		return eposCat;
	}

	public void setEposCat(String eposCat) {
		this.eposCat = eposCat;
	}

	public String getEposDept() {
		return eposDept;
	}

	public void setEposDept(String eposDept) {
		this.eposDept = eposDept;
	}

	
	


	


	
	
	
	
	


	
	

}
