package com.example.demo.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.user.Admin;
import com.example.demo.model.user.Patient;
import com.example.demo.model.user.Pharmacy;

public class MyUserDetails implements UserDetails{
	
	private String email;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	
	public MyUserDetails() {}
	
//	public MyUserDetails(String username) {
//		this.userName = username;
//	}

	public MyUserDetails(Pharmacy p) {
		// TODO Auto-generated constructor stub
		this.email = p.getPharmacyEmail();
		this.password = p.getPharmacyPassword();
		this.active = true;
		this.authorities = new ArrayList<GrantedAuthority>();
		this.authorities.add(new SimpleGrantedAuthority("ROLE_PHARMACY"));
	}

	public MyUserDetails(Patient pat) {
		// TODO Auto-generated constructor stub
		this.email = pat.getPatientEmail();
		this.password = pat.getPatientPassword();
		this.active = true;
		this.authorities = new ArrayList<GrantedAuthority>();
		this.authorities.add(new SimpleGrantedAuthority("ROLE_PATIENT"));
	}

	public MyUserDetails(Admin admin) {
		this.email = admin.getEmail();
		this.password = admin.getPassword();
		this.active = true;
		this.authorities = new ArrayList<GrantedAuthority>();
		this.authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.active;
	}

}
