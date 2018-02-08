package com.accolite.hibernate.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.accolite.hibernate.shoppingcart.models.Customer;

public class CustomerDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers(){
		return (List<Customer>) sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}
	
	
	public void saveCustomer(Customer customer) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);
	}
	
	public void updateCustomer(Customer customer) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		session.update(customer);
	}
	
	public Customer deleteCustomer(int id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		if (customer == null) {
			return null;
		}
		session.delete(customer);
		return customer;
	}
}
