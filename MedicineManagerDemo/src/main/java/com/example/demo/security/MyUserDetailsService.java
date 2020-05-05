package com.example.demo.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dal.PatientRepository;
import com.example.demo.dal.PharmacyRepository;
import com.example.demo.model.user.Admin;
import com.example.demo.model.user.Patient;
import com.example.demo.model.user.Pharmacy;

@Service
public class MyUserDetailsService implements UserDetailsService{

	
	@Autowired 
	PharmacyRepository mPharmacyRepo;
	
	@Autowired
	PatientRepository mPatientRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//return new MyUserDetails(username);
		if(username.equalsIgnoreCase("admin")) {
			return new MyUserDetails(Admin.getInstance());
		}else if(mPatientRepo.existsByPatientEmail(username)==true) {
			Patient pat = mPatientRepo.findByPatientEmail(username);
			return new MyUserDetails(pat);
		}else if(mPharmacyRepo.existsPharmacyByPharmacyEmail(username)==true) {
			Pharmacy p = mPharmacyRepo.findByPharmacyEmail(username).get();
			return new MyUserDetails(p);
		}else {
			throw new UsernameNotFoundException("Not found " + username);
		}
	}
	
	

}
