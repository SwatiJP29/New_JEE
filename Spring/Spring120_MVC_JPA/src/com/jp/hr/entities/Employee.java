package com.jp.hr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name="empRec")
@Table(name="EMPLOYEE1")
public class Employee {
	
	private int empID;
	
	@NotNull
	@Size(min = 3, max = 20, message = "Invalid length of First Name")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Employee First Name has invalid characters")
	private String firstName;
	
	@Size(min = 3, max = 20, message = "Invalid length of Last Name")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Employee First Name has invalid characters")
	private String lastName;
	
	public Employee(int empID, String firstName, String lastName) {
		
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee() {
		super();
	}
	
	@Id
	@Column(name="EMPLOYEE_ID")
	public int getEmpID() { //Property name: empID
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	@Column(name="FIRST_NAME")
	public String getFirstName() { //Property name: firstName
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LAST_NAME")
	public String getLastName() {   //Property name: lastName
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
