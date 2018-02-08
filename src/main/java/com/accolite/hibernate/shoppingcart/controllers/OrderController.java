package com.accolite.hibernate.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.hibernate.shoppingcart.dao.OrderDao;
import com.accolite.hibernate.shoppingcart.models.Order;

@RestController("order")
@RequestMapping("/order")
@Transactional
public class OrderController {
	@Autowired
	OrderDao orderdao;

	
	@GetMapping("/")
	public List<Order> getOrders() {
		return orderdao.getOrders();
	}

	@PostMapping("/")
	public ResponseEntity<Object> saveOrder(@RequestBody Order order) {
		try {
			orderdao.saveOrder(order);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
