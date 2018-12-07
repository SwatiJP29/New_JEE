package com.jpm.banking.entities;

import java.util.Set;

public class SavingAccount extends Account{
	private Double rateOfInterest;
	
	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}
	
	

	public SavingAccount(Double balance, Set<Customer> customer, Double rateOfInterest) {
		super(balance, customer);
		this.rateOfInterest = rateOfInterest;
	}



	public Double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	
	

}
