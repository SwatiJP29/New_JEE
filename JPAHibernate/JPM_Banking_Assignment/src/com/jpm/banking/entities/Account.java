package com.jpm.banking.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BANK_ACCOUNT")
public class Account {
	@Id
	@Column(name="ACC_ID")
	private Long accountId;
	
	@Column(name="CUST_BAL")
	private Double balance;
	
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Set<Customer> customer;
	

}
