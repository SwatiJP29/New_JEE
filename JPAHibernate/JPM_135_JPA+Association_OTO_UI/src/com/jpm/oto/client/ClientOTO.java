package com.jpm.oto.client;

import javax.persistence.EntityManager;

import com.jpm.oto.entities.Address;
import com.jpm.oto.entities.Employee;
import com.jpm.oto.util.JPAUtil;

public class ClientOTO {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.geEntityManager();
		em.getTransaction().begin();
		
		//addressobj
		Address homeAddress = new Address();
		homeAddress.setAddressId(120L);
		homeAddress.setStreet("MG Road");
		homeAddress.setCity("Pune");
		homeAddress.setState("Maharashtra");
		homeAddress.setZipCode("488765");
		
		//Employee obj
		Employee empObj = new Employee();
		empObj.setEmpId(101L);
		empObj.setEmpName("Swati");
		empObj.setEmpSal(99.99);
		
		//set address to the empObj
		empObj.setAddress(homeAddress);
		
		//now persist the empObj
		em.persist(empObj);
		em.persist(homeAddress);
		
		//Commit and close
		
		em.getTransaction().commit();
		em.close();
		
		

	}

}
