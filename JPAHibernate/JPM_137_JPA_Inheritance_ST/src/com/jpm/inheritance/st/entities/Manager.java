package com.jpm.inheritance.st.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="MGR")
public class Manager extends Employee {
	
	private Double bonus;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Manager(String empName, Double empSal, Double bonus) {
		super( empName, empSal);
		this.bonus = bonus;
	}



	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}



	@Override
	public String toString() {
		return "Manager [bonus=" + bonus + ", toString()=" + super.toString() + "]";
	}



	@Override
	public Double getEmpSal() {
		
		return super.getEmpSal() + bonus;
	}
	
	

}
