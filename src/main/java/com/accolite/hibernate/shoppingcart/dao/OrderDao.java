package com.accolite.hibernate.shoppingcart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.accolite.hibernate.shoppingcart.models.Order;

public class OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrders(){
		return (List<Order>) sessionFactory.getCurrentSession().createQuery("from Order").list();
	}
	
	public void saveOrder(Order order) throws Exception{
		sessionFactory.getCurrentSession().save(order);
	}
	
}
