package com.jp.hr.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Product {
	int productId;
	String productCategory;
	
	@NotNull
	@Size(min = 3, max = 20, message = "Invalid length of Product Name")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Product Name has invalid characters")
	String productName;
	float productPrice;
	public Product(int productId, String productCategory, String productName, float productPrice) {
		super();
		this.productId = productId;
		this.productCategory = productCategory;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productCategory=" + productCategory + ", productName="
				+ productName + ", productPrice=" + productPrice + "]";
	}
	
	

}
