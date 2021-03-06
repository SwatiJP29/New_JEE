/**
 * 
 */
package com.jpm.mtm.client;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import com.jpm.mtm.entities.Order;
import com.jpm.mtm.entities.Product;
import com.jpm.mtm.util.JPAUtil;

/**
 * @author Administrator
 *
 */
public class MTMClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager em = JPAUtil.geEntityManager();
		em.getTransaction().begin();
		
		
		Product elecProduct = new Product();
		elecProduct.setProductId(101L);
		elecProduct.setProductName("LED TV");
		elecProduct.setProductPrice(45000.76);
		
		Product beautyProduct = new Product();
		beautyProduct.setProductId(102L);
		beautyProduct.setProductName("LIPSTICK");
		beautyProduct.setProductPrice(450.76);
		
		Product babyProduct = new Product();
		babyProduct.setProductId(104L);
		babyProduct.setProductName("BABY SOAP");
		babyProduct.setProductPrice(100.98);
		
		Product eleProduct = new Product();
		eleProduct.setProductId(106L);
		eleProduct.setProductName("LED BULB");
		eleProduct.setProductPrice(450.76);
		
		
		//now define first order and add few products in it
		Order firstOrder = new Order();
		firstOrder.setOrderId(10L);
		firstOrder.setPurchaseDate(new Date());
		
		//now create a HashSet of Product
		Set<Product> products = new HashSet<>();
		products.add(elecProduct);
		products.add(beautyProduct);
		products.add(babyProduct);
		products.add(eleProduct);
		
		//firstOrder.setProducts(products);
		
		//now define second order and add few products in it
		Order secondOrder = new Order();
		secondOrder.setOrderId(20L);
		secondOrder.setPurchaseDate(new Date());
		
		//secondOrder.setProducts(products);
		
		
		//now Create a HashSet of Order and add it into set
		Set<Order> orders = new HashSet<>();
		orders.add(firstOrder);
		orders.add(secondOrder);
		
		//now set the products Orders
		elecProduct.setOrders(orders);
		beautyProduct.setOrders(orders);
		babyProduct.setOrders(orders);
		eleProduct.setOrders(orders);
		
		//now add product hasSet to the Order
		secondOrder.setProducts(products);
		firstOrder.setProducts(products);
		
		
		em.persist(firstOrder);
		em.persist(secondOrder);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
