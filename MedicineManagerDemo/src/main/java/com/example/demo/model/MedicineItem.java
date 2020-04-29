package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="medicineItemID", scope = Integer.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class MedicineItem {
	

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	int medicineItemID;
	int ipuCategory;
	@Column(unique = true)
	String barcode;
	String tradeName;
	
	
	
	String medicineStatus = "Current";
	
	
	
	
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemStockMedicine", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemStockLevel> stockItems = new ArrayList<ItemStockLevel>();
	
	
	public void addItemStockMed(ItemStockLevel itemStocklvl) {
		this.stockItems.add(itemStocklvl);
		itemStocklvl.setItemStockMedicine(this);
	}
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "lineItemMedicine", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PrescriptionLineItem> prescriptionLineItems = new ArrayList<PrescriptionLineItem>();
	
	
	public void addItemStockMed(PrescriptionLineItem lineItem) {
		this.prescriptionLineItems.add(lineItem);
		lineItem.setLineItemMedicine(this);
	}
	
	
	
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

	public int getIpuCategory() {
		return ipuCategory;
	}


	public void setIpuCategory(int ipuCategory) {
		this.ipuCategory = ipuCategory;
	}


	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradename(String tradename) {
		this.tradeName = tradename;
	}

	public String getMedicineStatus() {
		return medicineStatus;
	}

	public void setMedicineStatus(String medicineStatus) {
		this.medicineStatus = medicineStatus;
	}




	@Override
	public boolean equals(Object obj) {
		
		 if (obj == null) {
	            return false;
	        }

	        if (!MedicineItem.class.isAssignableFrom(obj.getClass())) {
	            return false;
	        }

	        final MedicineItem other = (MedicineItem) obj;
	        if ((this.barcode == null) ? (other.barcode != null) : !this.barcode.equals(other.barcode)) {
	            return false;
	        }

	        return true;
		
	}
	
//    public String hashCode() {
//        return barcode;
//    }
	

	
	
	
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
