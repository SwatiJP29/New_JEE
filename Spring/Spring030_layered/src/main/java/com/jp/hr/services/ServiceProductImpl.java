package com.jp.hr.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jp.hr.daos.DaoProduct;
import com.jp.hr.daos.DaoProductImpl;
import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;

@Service("serviceProduct")
public class ServiceProductImpl implements ServiceProduct{
	
	private DaoProduct daoProduct;
	
	public ServiceProductImpl() throws HrException{
		
	}
	
	
	@Autowired
	public ServiceProductImpl(@Qualifier("daoProductDS")DaoProduct daoProduct) {
		this.daoProduct = daoProduct;
	}

	@Override
	public ArrayList<Product> getProductList() throws HrException {
		return daoProduct.getProductList();
	}

	@Override
	public Product getProductDetails(int productId) throws HrException {
		return daoProduct.getProductDetails(productId);
	}

	@Override
	public boolean addNewProduct(Product product) throws HrException {
		return daoProduct.insertNewRecord(product);
	}

	@Override
	public ArrayList<Product> getEmplist() throws HrException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean updateProduct(Product product)throws HrException{
		return daoProduct.updateRecord(product);
	}

	@Override
	public boolean deleteProduct(int productId) throws HrException {
		return daoProduct.deleteRecord(productId);
	}

}
