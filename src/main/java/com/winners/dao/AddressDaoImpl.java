package com.winners.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.winners.dto.Address;

@Repository
public class AddressDaoImpl implements AddressDao {
	
	private NamedParameterJdbcTemplate npJdbcTemplate;
	
	private static final String INSERT_ADDRESS = "INSERT INTO ADDRESS VALUES(:addressId,:address,:addressType,:customerId)";
	private static final String DELETE_ADDRESS_BY_CUSTOMER_ID = "DELETE FROM ADDRESS WHERE CUSTOMER_ID = :customerId";
	private static final String GET_ADDRESS_BY_CUSTOMER_ID = "SELECT ADDRESS_ID,ADDRESS,ADDRESS_TYPE,CUSTOMER_ID FROM ADDRESS WHERE CUSTOMER_ID = :customerId";
	private static final String UPDATE_ADDRESS = "UPDATE ADDRESS SET ADDRESS = :address, ADDRESS_TYPE = :addressType WHERE ADDRESS_ID = :addressId";

	public AddressDaoImpl(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void addAddress(Address address) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("addressId", address.getAddressId());
		paramMap.put("address", address.getAddress());
		paramMap.put("addressType", address.getAddressType());
		paramMap.put("customerId", address.getCustomerId());
		npJdbcTemplate.update(INSERT_ADDRESS, paramMap);
	}

	@Override
	public void deleteAddressByCustomerId(Integer customerId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("customerId", customerId);
		npJdbcTemplate.update(DELETE_ADDRESS_BY_CUSTOMER_ID, paramMap);
	}

	@Override
	public List<Address> getAddressByCustomerId(Integer customerId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("customerId", customerId);
		return npJdbcTemplate.query(GET_ADDRESS_BY_CUSTOMER_ID, paramMap, new RowMapper<Address>() {

			@Override
			public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
				Address address = Address.builder()
										.addressId(rs.getInt("ADDRESS_ID"))
										.address(rs.getString("ADDRESS"))
										.addressType(rs.getString("ADDRESS_TYPE"))
										.customerId(rs.getInt("CUSTOMER_ID"))
										.build();
				return address;
			}
			
		});
	}

	@Override
	public void updateAddress(Address address) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("addressId", address.getAddressId());
		paramMap.put("address", address.getAddress());
		paramMap.put("addressType", address.getAddressType());
		npJdbcTemplate.update(UPDATE_ADDRESS, paramMap);
	}

	
}
