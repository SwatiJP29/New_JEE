package com.jpm.inheritance.client;

import javax.persistence.EntityManager;

import com.jpm.inheritance.util.JPAUtil;

import com.jpm.inheritance.entities.Employee;
import com.jpm.inheritance.entities.Manager;
import com.jpm.inheritance.entities.SalesManager;

public class ClientOTO {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.geEntityManager();
		em.getTransaction().begin();
		
		//addressobj
		
		Employee e1 = new Employee("Swati", 333.44);
		Manager m1 = new Manager("Swapna", e1.getEmpSal(), 55.99);
		
		SalesManager sm1 = new SalesManager("Zoya", 344.66, 34.87, 343.88);
		//persist them
		em.persist(e1);
		em.persist(m1);
		em.persist(sm1);
		
		//Commit and close
		
		em.getTransaction().commit();
		em.close();
		
		

	}

}