package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Pharmacy;

public interface PharmacyDAO extends CrudRepository<Pharmacy, Integer>{

}
