package com.jpm.collections.entities;

public class Employee implements Comparable<Employee>{
	
	private int empID;
	private String empName;
	private double empSal;
	private static int numId;
	private static final String coName; //blank final
	
	//static block is used to initialize only static variable. Single copy. shared
	static {
		numId = (int) (1000 + Math.random()*123.123);
		coName = "J P Morgan";
	}
	
	//initializer block - used to initialize instance var before creation of an object
	{
		empID = numId++;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Employee(String empName, double empSal) {
		super();
		this.empName = empName;
		this.empSal = empSal;
	}



	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public static String getConame() {
		return coName;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// comapre with empId as the method returns int
		return this.empID-o.empID;
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.hashCode()==obj.hashCode();
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getEmpID();
	}
	
	
	

}
