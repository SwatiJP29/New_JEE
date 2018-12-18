package com.jp.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

//http:localhost:8080//Spring_300_MvcJPARestNg/hr/empList
//http:localhost:8080//Spring_300_MvcJPARestNg/hr/empDetails1?id=105
//http:localhost:8080//Spring_300_MvcJPARestNg/hr/insertNewEmployee/100789/jgjgh/gjgjgjjj
@RestController
public class HomePageController {

	@Autowired
	@Qualifier("service") // This service name is taken from the ServiceEmployeeImpl class which is annotated by @Service
	private ServiceEmployee empService; // Creating the reference to the service layer
	
	

	@RequestMapping(value = "/empList",method = RequestMethod.GET,headers="Accept=application/json")
	public List<Employee> getEmpList() {
		List<Employee> empList = null;
		try {
			empList = empService.getEmpList();

		} catch (HrException e) {
			e.printStackTrace();
		}
		return empList;
	}

	@RequestMapping(value = "/empDetails1", method = RequestMethod.GET,headers="Accept=application/json")
	public Employee getEmpDetails1(@RequestParam("id") int empID) {
		Employee emp = null;
		
		try {
			emp = empService.getEmpDetails(empID);
			System.out.println(emp);
		} catch (HrException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	@RequestMapping(value = "/empDetails2/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public Employee getEmpDetails2(@PathVariable("id") int empID) { //We can user either path variable or path param
		Employee emp = null;
		
		try {
			emp = empService.getEmpDetails(empID);
			System.out.println(emp);
		} catch (HrException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	@RequestMapping(value = "/insertNewEmployee/{id}/{nameF}/{nameL}", method = RequestMethod.GET,headers="Accept=application/json")
	public boolean insertNewEmployee(@PathVariable("id") int id, @PathVariable("nameF") String nameF, @PathVariable("nameL") String nameL) throws HrException { //We can user either path variable or path param
		Employee emp = new Employee(id, nameF, nameL);
		return empService.joinNewEmployee(emp);
		
	}

}
