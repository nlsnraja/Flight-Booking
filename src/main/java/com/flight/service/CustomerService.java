package com.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.entities.Customer;

@Service
public interface CustomerService {
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	Customer deleteCustomer(Customer customer);
	Customer viewCustomer(int customerId);
	List<Customer> viewAllCustomers();
}
