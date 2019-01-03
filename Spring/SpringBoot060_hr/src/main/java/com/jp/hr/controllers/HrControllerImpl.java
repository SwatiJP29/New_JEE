package com.jp.hr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jp.hr.entities.Employee;
import com.jpm.hr.exceptions.HrException;
import com.jpm.hr.service.HrServices;

@Controller
public class HrControllerImpl {
	
	@Autowired
	@Qualifier("hrServices")
	private HrServices services;
	
	@RequestMapping("/home")
	public String getHomePage(){
		return "Home";
	}
	
	@RequestMapping("/empDetails")
	public ModelAndView getEmpDetails() throws HrException{
		Employee emp = services.getEmpDetails(2);
		ModelAndView mAndV = new ModelAndView("ViewDetails");
		mAndV.addObject("emp", emp);
		return mAndV;
	}
	
}
