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
	
	//
	String gmsNumber;
	String packSize;
	String manufacturer;
	String agent;
	String pc;
	String tradePrice;
	String genericName;
	String warnings;
	String ingredientList1;
	String atc1;
	String counsel;
	String strength;
	String forms;
	
	
	
	
	
	
	
	
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

	
	public String getGmsNumber() {
		return gmsNumber;
	}



	public void setGmsNumber(String gmsNumber) {
		this.gmsNumber = gmsNumber;
	}



	public String getPackSize() {
		return packSize;
	}



	public void setPackSize(String packSize) {
		this.packSize = packSize;
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



	public String getPc() {
		return pc;
	}



	public void setPc(String pc) {
		this.pc = pc;
	}



	public String getTradePrice() {
		return tradePrice;
	}



	public void setTradePrice(String tradePrice) {
		this.tradePrice = tradePrice;
	}



	public String getGenericName() {
		return genericName;
	}



	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}



	public String getWarnings() {
		return warnings;
	}



	public void setWarnings(String warnings) {
		this.warnings = warnings;
	}



	public String getIngredientList1() {
		return ingredientList1;
	}



	public void setIngredientList1(String ingredientList1) {
		this.ingredientList1 = ingredientList1;
	}



	public String getAtc1() {
		return atc1;
	}



	public void setAtc1(String atc1) {
		this.atc1 = atc1;
	}



	public String getCounsel() {
		return counsel;
	}



	public void setCounsel(String counsel) {
		this.counsel = counsel;
	}



	public String getStrength() {
		return strength;
	}



	public void setStrength(String strength) {
		this.strength = strength;
	}



	public String getForms() {
		return forms;
	}



	public void setForms(String forms) {
		this.forms = forms;
	}



	public List<ItemStockLevel> getStockItems() {
		return stockItems;
	}



	public void setStockItems(List<ItemStockLevel> stockItems) {
		this.stockItems = stockItems;
	}



	public List<PrescriptionLineItem> getPrescriptionLineItems() {
		return prescriptionLineItems;
	}



	public void setPrescriptionLineItems(List<PrescriptionLineItem> prescriptionLineItems) {
		this.prescriptionLineItems = prescriptionLineItems;
	}



	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
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




