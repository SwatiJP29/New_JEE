package com.jp.hr.controllers;

import java.util.ArrayList;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;


/*@Controller : A kind of @Component to declare SpringMVC controllers
 * @Request Mapping : To map a controlling method to the URL
 * @RequestParam - To take single QueryString or FormData field value.
 * Multi-action Controllers - There would be method for every action.
 * 
 * 
 */
@Controller
public class HomePageController {
	
	@Autowired
	@Qualifier("service") //This service name is taken from the ServiceEmployeeImpl class which is annotated by @Service
	private ServiceEmployee empService; //Creating the reference to the service layer

	//The below method will return the JSP name hence the return type is String
	@RequestMapping("homePage.hr") //when the url has "homePage" then this method is executed. It is same as command in FrontController 
	public String getHomePage(){
		System.out.println("In Home Page");
		return "HomePage";
	}
	
	@RequestMapping("getEmpList.hr")
	public ModelAndView getEmpList(){
		ModelAndView mAndV = new ModelAndView();
		try {
			ArrayList<Employee> empList = empService.getEmpList();
			mAndV.addObject("empList", empList);
			
			mAndV.setViewName("EmpList");
			
		} catch (HrException e) {
			e.printStackTrace();
		}
		return mAndV;
	}
	
	@RequestMapping("empDetails.hr") //This url has come from the emplist.jsp
	public ModelAndView getEmpDetails(@RequestParam("id") int empID){
		/*String strEmpId = request.getParameter("id");
		int empID = Integer.parseInt(strEmpId);*/
		ModelAndView mAndV = new ModelAndView();
		try {
			Employee emp = empService.getEmpDetails(empID);
			mAndV.addObject("empDetails", emp);
			
			mAndV.setViewName("EmpDetails");
			
		} catch (HrException e) {
			e.printStackTrace();
		}
		return mAndV;
	}
	
	@RequestMapping("registrationForm.hr") //This url has come from the emplist.jsp
	public String getRegistrationForm(Model model){
		Employee emp = new Employee();
		model.addAttribute("command", emp);
		return "EntryPage";
	}
	
	@RequestMapping("submitRegistrationData.hr") //This url has come from the emplist.jsp
	public String submitRegistrationData(@ModelAttribute("command") Employee emp, Model model){
		System.out.println(emp);
		
		try {
			empService.joinNewEmployee(emp);
			return "SaveSuccess";
		} catch (HrException e) {
			model.addAttribute("msg", "Insert failed. " + e.getMessage());
			return "EntryPage";
		}
		
	}
	
	
}
