package com.jpm.banking.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_CUSTOMER")
public class Customer {
	@Id
	@Column(name="CUST_ID")
	@GeneratedValue(generator="cust_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="cust_gen", sequenceName="cust_seq", allocationSize=1)
	private Long customerId;
	
	@Column(name="CUST_NAME")
	private String customerName;
	
	@Column(name="CUST_PHONE")
	private Long phone;
	
	@Column(name="CUST_ADD")
	private String address;
	
	@Column(name="CUST_EMAIL")
	private String email;
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private Set<Account> accounts;
	

}
