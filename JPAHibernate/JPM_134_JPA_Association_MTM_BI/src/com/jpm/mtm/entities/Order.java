package com.jpm.mtm.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ORDER_MTM")
public class Order {
	@Id
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Temporal(TemporalType.DATE)//required for Date and Calendar Types
	@Column(name="ORDER_DATE")
	private Date purchaseDate;
	
	//Step ! : mention the relation ship between order and product.many products will have may orders and vice versa
	@ManyToMany(cascade=CascadeType.ALL)
	
	//Step 2: JoinTable
	@JoinTable(name="ORDER_PROCUCT_MTM",
	
	//Join columns
	joinColumns={@JoinColumn(name="ORDER_ID")},
	
	//inverse join column
	inverseJoinColumns={@JoinColumn(name="PRODUCT_ID")
	})
	private Set<Product> products = new HashSet<>();
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", purchaseDate=" + purchaseDate + ", products=" + products + "]";
	}

	
	
	

}
