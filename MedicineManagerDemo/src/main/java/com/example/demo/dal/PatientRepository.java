package com.example.demo.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Medicine;
import com.example.demo.model.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Integer>{

	
}
