package com.winners.service;

import java.util.List;
import java.util.Map;

import com.winners.dto.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
	void deleteCustomer(Integer customerId);
	Customer findCustomer(Integer customerId);
	void updateCustomer(Customer customer);
	
	Integer getCustomerCount();
	Double getAverageCustomerAge();
	List<String> getAllCustomerNames();
	List<Map<String, Object>> getAllCustomerIdNames();
	List<Integer> getAllCustomerAge();
}
