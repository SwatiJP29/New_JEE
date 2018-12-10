package com.jp.hr.client;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jp.hr.entities.Employee;
import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;
import com.jp.hr.services.ServiceEmployeeImpl;
import com.jp.hr.services.ServiceProduct;

public class TestServices {

	public static void main(String[] args) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
			ServiceEmployee empService = (ServiceEmployee) ctx.getBean("service");
			
			ArrayList<Employee> empList = empService.getEmpList();
			ServiceProduct productService = (ServiceProduct) ctx.getBean("serviceProduct");
			ArrayList<Product> productList = productService.getProductList();
			
			for (Employee emp : empList){
				System.out.println(emp);
			}
		} catch (HrException e) {
			
			e.printStackTrace();
		}

	}

}
