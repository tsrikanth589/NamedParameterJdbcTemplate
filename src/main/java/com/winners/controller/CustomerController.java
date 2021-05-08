package com.winners.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winners.dto.Address;
import com.winners.dto.Customer;
import com.winners.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/add")
	public String addCustomerPage() {
		return "add-customer";
	}
	
	@PostMapping("/add")
	public String addCustomer(Customer customer, HttpServletRequest req) {
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(Address.builder()
								.addressId(Integer.parseInt(req.getParameter("homeAddressId")))
								.address(req.getParameter("homeAddress"))
								.addressType("Home")
								.customerId(customer.getCustomerId())
								.build()
						);
		addressList.add(Address.builder()
				.addressId(Integer.parseInt(req.getParameter("workAddressId")))
				.address(req.getParameter("workAddress"))
				.addressType("Work")
				.customerId(customer.getCustomerId())
				.build()
		);
		customer.setAddressList(addressList);
		System.out.println(customer);
		customerService.addCustomer(customer);
		System.out.println("Customer saved successfully...");
		return "add-customer-success";
	}
	
	@GetMapping("/delete")
	public String deleteCustomerPage() {
		
		return "delete-customer";
	}
	
	@PostMapping("/delete")
	public String deleteCustomer(Integer customerId) {
		customerService.deleteCustomer(customerId);
		return "delete-customer-success";
	}
	
	@GetMapping("/find-customer-page")
	public String findCustomerPage() {
		return "find-customer";
	}
	
	@GetMapping("/find")
	public @ResponseBody Customer findCustomer(Integer customerId) {
		return customerService.findCustomer(customerId);
	}
	
	@GetMapping("/update")
	public String updateCustomerPage() {
		return "update-customer";
	}
	
	@PostMapping("/update")
	public String updateCustomer(Customer customer, HttpServletRequest req) {
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(Address.builder()
								.addressId(Integer.parseInt(req.getParameter("homeAddressId")))
								.address(req.getParameter("homeAddress"))
								.addressType("Home")
								.customerId(customer.getCustomerId())
								.build()
						);
		addressList.add(Address.builder()
				.addressId(Integer.parseInt(req.getParameter("workAddressId")))
				.address(req.getParameter("workAddress"))
				.addressType("Work")
				.customerId(customer.getCustomerId())
				.build()
		);
		customer.setAddressList(addressList);
		customerService.updateCustomer(customer);
		System.out.println("Customer updated successfully...");
		return "update-customer-success";
	}
	
	@GetMapping("/count")
	public @ResponseBody Integer getCustomerCount() {
		return customerService.getCustomerCount();
	}
	
	@GetMapping("/avg-age")
	public @ResponseBody Double getAverageCustomerAge() {
		return customerService.getAverageCustomerAge();
	}
	
	@GetMapping("/get-all-customer-names")
	public @ResponseBody List<String> getAllCustomerNames() {
		return customerService.getAllCustomerNames();
	}
	
	@GetMapping("/get-all-customer-id-names")
	public @ResponseBody List<Map<String, Object>> getAllCustomerIdNames() {
		return customerService.getAllCustomerIdNames();
	}
	
	@GetMapping("/get-all-customer-age")
	public @ResponseBody List<Integer> getAllCustomerAge() {
		return customerService.getAllCustomerAge();
	}
}	
