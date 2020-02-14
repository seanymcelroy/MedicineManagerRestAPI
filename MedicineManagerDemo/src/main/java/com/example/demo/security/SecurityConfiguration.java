//package com.example.demo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
////This is our base class for setting up our security settings.
//
////Let Spring know this is the config class
////@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//	
//	//User DAO
//	@Autowired
//	UserDetailsService userDetailsService;
//	
//
//	//Authentication
//	@Override
//	protected void configure(AuthenticationManagerBuilder authmb) throws Exception {
//		
//		//Authentication will use a userDetailsService 
//		authmb.userDetailsService(userDetailsService);
//	}
//	
//	//Authorization.
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//			.antMatchers("/securedAPI").hasAnyRole("USER")
//			.antMatchers("/test").permitAll()
//			.and().formLogin();
//	}
//
//	
//	
//	
//	//Need a Password Encoder object
//	
//	//Mthd returns password Encoder
//
//
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		//No encryption
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
//}
