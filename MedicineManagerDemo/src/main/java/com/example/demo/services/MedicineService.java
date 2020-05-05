package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.ItemStockLevelRepository;
import com.example.demo.dal.MedicineItemRepository;
import com.example.demo.dal.PharmacyRepository;
import com.example.demo.model.ItemStockLevel;
import com.example.demo.model.MedicineItem;
import com.example.demo.model.user.Pharmacy;

@Service
public class MedicineService {
	
	@Autowired
	MedicineItemRepository mMedItemRepo;
	
	@Autowired
	ItemStockLevelRepository mStockItemRepo;
	
	@Autowired
	PharmacyRepository mPharmacyRepo;
	
	
	public List<MedicineItem> updateMedicineList(List<MedicineItem> newMedList){
		
		List<MedicineItem> currentMedItemList = mMedItemRepo.findAll();
		
		List<Pharmacy> allPharmacies = mPharmacyRepo.findAll();

		
		for(MedicineItem medItem : currentMedItemList) {
			if(newMedList.contains(medItem)) {
				medItem.setMedicineStatus("Current");
				continue;
			}
			medItem.setMedicineStatus("End Of Life");
		}
		
		for(MedicineItem newmedItem : newMedList) {
			if(currentMedItemList.contains(newmedItem)) {
				
				continue;
			}
			
			for(Pharmacy pharmacyX : allPharmacies) {
			newmedItem.addItemStockMed(new ItemStockLevel(pharmacyX));
			}
			currentMedItemList.add(newmedItem);
		}
		

		mMedItemRepo.saveAll(currentMedItemList);
		
		return newMedList;
	}

	public List<MedicineItem> fetchAllMedItemList() {
		return mMedItemRepo.findAll();
		// TODO Auto-generated method stub
		
	}
	
	public List<String> fetchAllMedicineNames(){
		
		List <String> medItemNamesList = new ArrayList<>();
		for(MedicineItem m: mMedItemRepo.findAll()) {
			medItemNamesList.add(m.getTradeName());
		}
		return medItemNamesList;
		
	}
	
	public MedicineItem getMedicineItemByBarcode(String barcode) {
		return mMedItemRepo.findMedicineItemByBarcode(barcode);
	}
	
	public MedicineItem getMedicineItemByID(int id) {
		return mMedItemRepo.getOne(id);
	}
	
	
	public List<MedicineItem> getPharmacyAvailableMedicine(Pharmacy p){
		
		List<MedicineItem> availableMedicine = new ArrayList<>();
		
		for (ItemStockLevel stockItem: mStockItemRepo.findAllByItemStockPharmacy(p)) {
			if (stockItem.getQuantity()>0) {
				availableMedicine.add(stockItem.getItemStockMedicine());
			}
		}
		return availableMedicine;
		
	}
	
	
	
	
	
	//Stock Items

}
