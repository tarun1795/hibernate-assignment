package com.accolite.hibernate.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.hibernate.assignment.dao.CustomerDao;
import com.accolite.hibernate.assignment.models.Customer;

@RestController
@RequestMapping("/customer")
@Transactional
public class CustomerController {
	@Autowired
	CustomerDao customerdao;

	
	@GetMapping("/")
	public List<Customer> getCustomers() {
		return customerdao.getCustomers();
	}

	@PostMapping("/")
	public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
		try {
			customerdao.addCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
		try {
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("id") int id) {
		try {
			
			Customer customer = customerdao.deleteCustomer(id);
			if (customer == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
