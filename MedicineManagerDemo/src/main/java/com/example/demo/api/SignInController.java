package com.example.demo.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.PharmacyDAO;
import com.example.demo.model.Pharmacy;

@Controller
public class SignInController {

	@Autowired
	PharmacyDAO dao;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Reached homePage controller method");
		
		//SpringBoot doesnt support JSP.
		//Add support for JSP. TomCat JASPER
		return "IndexPage.jsp";
		
		//SpringBoot Auto config
		//SpringBoot looks for your web pages inside webapp folder
	}
	
	@RequestMapping("/signUp")
	public ModelAndView SignIn(Pharmacy pharmacy) {
		
		//Save pharmacy obj to database
		dao.save(pharmacy);
		
		//obj + view stored
		ModelAndView mv = new ModelAndView();
		
		//Testing
		System.out.println("Sign in success" + pharmacy);
		
		
		mv.addObject(pharmacy);
		mv.setViewName("SignInSuccess.jsp");
		
		return mv;
	}
	
	@RequestMapping("/viewAllPharmaciesOnDatabase")
	public ModelAndView showPharmacies() {
		
		//List of pharmacies in system
		List<Pharmacy> pharmacyList=(List<Pharmacy>) dao.findAll();
		
		//Test to see if data retrieval is working
		for(Pharmacy p: pharmacyList) {
			System.out.println(p);
		}
		
		//Setting model view to list page and assigning the list item to it
		ModelAndView mv= new ModelAndView("PharmacyList.jsp"); 
		mv.addObject(pharmacyList);
		
		return mv;
		
	}
	
	
	
	
//	@RequestMapping("/DeleteAccount")
//	public String DeleteAccount(Pharmacy myPharmacyObject) {
//		
//		System.out.print(myPharmacyObject);
//		
//		dao.delete(myPharmacyObject);
//		return "IndexPage.jsp";
//		
//		
//	}
}
