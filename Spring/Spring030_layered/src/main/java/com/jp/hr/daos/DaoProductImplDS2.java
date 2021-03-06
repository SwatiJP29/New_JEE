package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.hr.entities.Employee;
import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;

@Repository("daoProductDS")
public class DaoProductImplDS2 implements DaoProduct {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public ArrayList<Product> getProductList() throws HrException {
		ArrayList<Product> productList = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			 connect = dataSource.getConnection();
			 stmt = connect.createStatement();
			 rs = stmt.executeQuery("select productid,productcategory,productname, productprice from products");
			
			
			 while (rs.next()){
					int productId = rs.getInt("productid");
					String productCategory = rs.getString("productcategory");
					String productName = rs.getString("productname");
					float productPrice = rs.getFloat("productprice");
					productList.add(new Product(productId, productCategory, productName, productPrice));
			}
		} catch ( SQLException e) {
			
			throw new HrException("Problem in fetching", e);

		} finally {
			try {
				if (rs!=null){
					rs.close();
				}
				if (stmt!=null){
					stmt.close();
				}
				
				//factory.closeConnection();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
		
		return productList;
	}

	
	@Override
	public Product getProductDetails(int productId) throws HrException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertNewRecord(Product product) throws HrException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecord(int productId) throws HrException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRecord(Product product) throws HrException {
		// TODO Auto-generated method stub
		return false;
	}

}
