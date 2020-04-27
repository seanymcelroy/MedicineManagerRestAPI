package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.NonNull;

import com.example.demo.model.user.Pharmacy;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="itemStockLevelID", scope = Integer.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ItemStockLevel {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "item_stock_level_id")
	int itemStockLevelID;
	
	int quantity =0;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="Medicine_item_id")
	MedicineItem itemStockMedicine;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Pharmacy_id")
	@JsonIdentityReference(alwaysAsId = true)
	Pharmacy itemStockPharmacy;
	
	
	
	///Constructors
		
	public ItemStockLevel() {
		super();
	}
	
	public ItemStockLevel(int quantity, MedicineItem itemStockMedicine) {
		super();
		this.quantity = quantity;
		this.itemStockMedicine = itemStockMedicine;
	}
	
	public ItemStockLevel(Pharmacy itemStockPharmacy) {
		super();
		this.itemStockPharmacy = itemStockPharmacy;
	}
	
	
	public ItemStockLevel(MedicineItem itemStockMedicine, Pharmacy itemStockPharmacy) {
		super();
		this.itemStockMedicine = itemStockMedicine;
		this.itemStockPharmacy = itemStockPharmacy;
	}

	public ItemStockLevel(int quantity, MedicineItem itemStockMedicine, Pharmacy itemStockPharmacy) {
		super();
		this.quantity = quantity;
		this.itemStockMedicine = itemStockMedicine;
		this.itemStockPharmacy = itemStockPharmacy;
	}

	public int getItemStockLevelID() {
		return itemStockLevelID;
	}



	public void setItemStockLevelID(int itemStockLevelID) {
		this.itemStockLevelID = itemStockLevelID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MedicineItem getItemStockMedicine() {
		return itemStockMedicine;
	}

	public void setItemStockMedicine(MedicineItem itemStockMedicine) {
		this.itemStockMedicine = itemStockMedicine;
	}

	public Pharmacy getItemStockPharmacy() {
		return itemStockPharmacy;
	}

	public void setItemStockPharmacy(Pharmacy itemStockPharmacy) {
		this.itemStockPharmacy = itemStockPharmacy;
	}

	


		

}
