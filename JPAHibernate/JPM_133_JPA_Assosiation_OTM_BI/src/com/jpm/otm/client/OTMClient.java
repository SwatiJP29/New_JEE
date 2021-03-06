package com.jpm.otm.client;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import com.jpm.otm.entity.Department;
import com.jpm.otm.entity.Employee;
import com.jpm.otm.util.JPAUtil;

public class OTMClient {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.geEntityManager();
		
		//create the object to be persisted
		
		//--dept_obj
		
		Department department = new Department();
		department.setDeptId(10L);
		department.setDeptName("Sales");
		
		//create employee obj
		Employee e1 = new Employee();
		e1.setEmpId(101L);
		e1.setEmpName("Swati");
		e1.setEmpSal("99987");
		
		//set department of the employee
		
		e1.setDepartment(department);
		
		Employee e2 = new Employee();
		e2.setEmpId(102L);
		e2.setEmpName("Neha");
		e2.setEmpSal("76575657");
		
		//set department of the employee
		
		e2.setDepartment(department);
		
		
		//Create the set of employees and set to the department
		
		Set<Employee> employees= new HashSet<>();
		
		employees.add(e1);
		employees.add(e2);
		
		//set the employees set in Department object
		department.setEmployees(employees);
		
		
		//begin transaction
		entityManager.getTransaction().begin();
		
		//persist the department
		entityManager.persist(department);
		
		//commit transaction
		entityManager.getTransaction().commit();
		
		//close em
		entityManager.close();
		
		
	}

}
