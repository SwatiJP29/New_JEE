package com.jpm.mtm.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_MTM")
public class Product {
	
	@Id
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_PRICE")
	private Double productPrice;
	
	//Define the mapping
	
	//Fetch Type we have made LAZY
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="products")
	private Set<Order> orders = new HashSet<>();
	
	/*Fetch Type.Eager loading of collection means that they are fetched fully at the time of their parents
	 * are fetched.
	 * 
	 */
	
	public Product() {
		
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", orders=" + orders + "]";
	}
	
	

}
