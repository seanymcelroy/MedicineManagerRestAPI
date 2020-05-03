package com.example.demo.services;


import java.util.Comparator;

import com.example.demo.model.Prescription;

public class PrescriptionComparator implements Comparator<Prescription>{

    @Override
    public int compare(Prescription prescription, Prescription t1) {
        return Long.compare(t1.getPrescriptionCreationDate(), prescription.getPrescriptionCreationDate());
    }



	
}
