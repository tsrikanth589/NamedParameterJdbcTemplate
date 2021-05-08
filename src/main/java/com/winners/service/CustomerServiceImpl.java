package com.winners.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winners.dao.AddressDao;
import com.winners.dao.CustomerDao;
import com.winners.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
		customer.getAddressList().forEach(addressDao::addAddress);
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer customerId) {
		addressDao.deleteAddressByCustomerId(customerId);
		customerDao.deleteCustomer(customerId);
	}

	@Override
	public Customer findCustomer(Integer customerId) {
		Customer customer = customerDao.findCustomer(customerId);
		customer.setAddressList(addressDao.getAddressByCustomerId(customerId));
		System.out.println(customer);
		return customer;
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customer.getAddressList().forEach(addressDao::updateAddress);
		customerDao.updateCustomer(customer);
	}

	@Override
	public Integer getCustomerCount() {
		return customerDao.getCustomerCount();
	}

	@Override
	public Double getAverageCustomerAge() {
		return customerDao.getAverageCustomerAge();
	}

	@Override
	public List<String> getAllCustomerNames() {
		return customerDao.getAllCustomerNames();
	}

	@Override
	public List<Map<String, Object>> getAllCustomerIdNames() {
		return customerDao.getAllCustomerIdNames();
	}

	@Override
	public List<Integer> getAllCustomerAge() {
		return customerDao.getAllCustomerAge();
	}
	
	
}
