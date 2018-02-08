package com.accolite.hibernate.assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.accolite.hibernate.assignment.models.Order;

public class OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	public List<Order> getOrders(){
		return sessionFactory.getCurrentSession().createQuery("from Order").list();
	}
	
	public void saveOrder(Order order) throws Exception{
		sessionFactory.getCurrentSession().save(order);
	}
	
}
