package com.jpm.banking.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_ACCOUNT")
@Inheritance(strategy=InheritanceType.JOINED)
public class Account {
	
	@Id
	@Column(name="ACC_ID")
	@GeneratedValue(generator="acc_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="acc_gen", sequenceName="acc_seq", allocationSize=1)
	private Long accountId;
	
	@Column(name="CUST_BAL")
	private Double balance;
	
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Set<Customer> customer;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(Double balance, Set<Customer> customer) {
		super();
		this.balance = balance;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", customer=" + customer + "]";
	}
	
	

}
