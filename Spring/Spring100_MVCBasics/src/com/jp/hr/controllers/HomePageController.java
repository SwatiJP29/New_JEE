package com.jp.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	//The below method will return the JSP name hence the return type is String
	@RequestMapping("/homePage") //when the url has "homePage" then this method is executed. It is same as command in FrontController 
	public String getHomePage(){
		System.out.println("In Home Page");
		return "/HomePage.jsp";
	}
}
