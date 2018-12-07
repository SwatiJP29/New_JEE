package com.jpm.banking.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CURRENT_ACC")
public class CurrentAccount extends Account {
	private Long overDraftLimit;
	
	public CurrentAccount() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CurrentAccount(Double balance, Set<Customer> customer, Long overDraftLimit) {
		super(balance, customer);
		this.overDraftLimit = overDraftLimit;
	}



	public CurrentAccount(Long overDraftLimit) {
		super();
		this.overDraftLimit = overDraftLimit;
	}
	
	
}
