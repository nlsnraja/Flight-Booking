package com.flight.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.CustomerRepository;
import com.flight.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	// ADD CUSTOMER
	@Override
	public Customer addCustomer(Customer customer) {
		return repository.save(customer);
	}

	// UPDATE CUSTOMER
	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cust = repository.findById(customer.getCustomerId())
				.orElseThrow(() -> new EntityNotFoundException("Currently No Customer is available with this id"));
		cust.setEmail(customer.getEmail());
		return repository.save(cust);
	}

	// DELETE CUSTOMER
	@Override
	public Customer deleteCustomer(Customer customer) {
		repository.findById(customer.getCustomerId())
				.orElseThrow(() -> new EntityNotFoundException("Currently No Customer is available with this id"));
		repository.delete(customer);
		return null;
	}

	// VIEW ALL CUSTOMER
	@Override
	public List<Customer> viewAllCustomers() {
		List<Customer> cust = repository.findAll();
		if (cust.isEmpty()) {
			throw new NullPointerException("Currently No Customers are available..");
		}
		return cust;
	}

	// VIEW CUSTOMER BY ID
	@Override
	public Customer viewCustomer(int customerId) {
		Customer cust = repository.findById((long) customerId)
				.orElseThrow(() -> new EntityNotFoundException("Currently No Customer is available with this id"));
		return cust;
	}
}
