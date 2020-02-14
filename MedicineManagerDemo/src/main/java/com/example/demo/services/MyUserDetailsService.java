//package com.example.demo.services;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.dal.PharmacyUserRepository;
//import com.example.demo.model.user.MyUserDetails;
//import com.example.demo.model.user.UserPharmacy;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService{
//
//	@Autowired
//	PharmacyUserRepository pharmUserRepository;
//	
//	//this connects to a source of user information
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		Optional<UserPharmacy> pharmacyUser = pharmUserRepository.findByUserName(username);
//		
//		pharmacyUser.orElseThrow(()-> new  UsernameNotFoundException("Not found " + username));
//		return pharmacyUser.map(MyUserDetails::new).get();
//	}
//
//}
