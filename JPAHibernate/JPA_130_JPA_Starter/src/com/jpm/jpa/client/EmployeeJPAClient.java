package com.jpm.jpa.client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpm.jpa.entities.Employee;

public class EmployeeJPAClient {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter Employee ID");
//		int empId = scanner.nextInt(); //We are taking empid from the user as this is a primary key
		
		System.out.println("Enter Name");
		String name = scanner.next();
		
		System.out.println("Enter Salary");
		double salary = scanner.nextDouble();
		
		
		String persistenceUnitName = "JPA-PU"; // got it from the persistence.xml placed in META_INF
		
		//step 1: Create EntityManagerFactory object
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		
		//step 2: create EntityManager object
		EntityManager em = emFactory.createEntityManager();
		
		//step 3: Begin Transaction
		em.getTransaction().begin();
		
		//step 4: Create the entity object and Persist entity 
		Employee employee = new Employee(name, salary);
		em.persist(employee);
		
		//step 5: commit transaction
		em.getTransaction().commit();
		
		
		//Fetch the record from the database with the help of primary key
		Employee e1 = em.find(Employee.class, employee.getEmployeeId());
		System.out.println("Employee : "+ e1);
		
		//step 6: close EntityManager
		em.close();
		
		//step 7: close EntityManagerFactory
		emFactory.close();

	}

}
