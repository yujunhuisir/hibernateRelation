package com.excelib;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.excelib.utils.HibernateUtils;

public class Test {
	public static void main(String[] args) {
	  fuc();
		
	}
	
	  public static void  fuc(){
	        Session session = HibernateUtils.getSession();
	        Transaction transaction = session.beginTransaction();
	        Category c1 = new Category();
	        c1.setCname("水果");
	        Product p1 = new Product();
	        p1.setPname("苹果");
	        p1.setPrice(5);
	        c1.getProducts().add(p1);
	        p1.setCategory(c1);
	        
	        session.save(c1);
	         transaction.commit();
	         session.close();
	    }
}
