package com.winners.dao;

import java.util.List;

import com.winners.dto.Address;

public interface AddressDao {
	void addAddress(Address address);
	void deleteAddressByCustomerId(Integer customerId);
	List<Address> getAddressByCustomerId(Integer customerId);
	void updateAddress(Address address);
}
