package com.winners.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.winners.dto.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	private NamedParameterJdbcTemplate npJdbcTemplate;
	
	private static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER VALUES(:customerId,:firstName,:lastName,:mobile,:email,:age)";
	private static final String DELETE_CUSTOMER = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = :customerId";
	private static final String FIND_CUSTOMER = "SELECT CUSTOMER_ID,FIRST_NAME,LAST_NAME,MOBILE,EMAIL,AGE FROM CUSTOMER WHERE CUSTOMER_ID = :customerId";
	private static final String UPDATE_CUSTOMER = "UPDATE CUSTOMER SET FIRST_NAME = :firstName, LAST_NAME = :lastName, MOBILE = :mobile, EMAIL = :email, AGE = :age WHERE CUSTOMER_ID = :customerId";
	
	private static final String GET_CUSTOMER_COUNT = "SELECT COUNT(1) FROM CUSTOMER";
	private static final String GET_AVERAGE_CUSTOMER_AGE = "SELECT AVG(AGE) FROM CUSTOMER";

	public CustomerDaoImpl(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		System.out.println("---->Datasourec : " + dataSource);
		System.out.println(dataSource.getClass().getName());
	}


	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		/*
		 * Map<String, Object> paramMap = new HashMap<String, Object>();
		 * paramMap.put("customerId", customer.getCustomerId());
		 * paramMap.put("firstName", customer.getFirstName()); paramMap.put("lastName",
		 * customer.getLastName()); paramMap.put("age", customer.getAge());
		 * paramMap.put("mobile", customer.getMobile()); paramMap.put("email",
		 * customer.getEmail()); 
		 * npJdbcTemplate.update(CustomerDaoImpl.INSERT_CUSTOMER,
		 * paramMap);
		 */
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(customer);
		npJdbcTemplate.update(INSERT_CUSTOMER, paramSource);
	}


	@Override
	@Transactional
	public void deleteCustomer(Integer customerId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("customerId", customerId);
		npJdbcTemplate.update(DELETE_CUSTOMER, paramMap);
	}


	@Override
	@Transactional(readOnly = true)
	public Customer findCustomer(Integer customerId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("customerId", customerId);
		return npJdbcTemplate.queryForObject(FIND_CUSTOMER, paramMap, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = Customer.builder()
											.customerId(rs.getInt("CUSTOMER_ID"))
											.firstName(rs.getString("FIRST_NAME"))
											.lastName(rs.getString("LAST_NAME"))
											.mobile(rs.getString("MOBILE"))
											.email(rs.getString("EMAIL"))
											.age(rs.getInt("AGE"))
											.build();
				return customer;
			}
		});
	}


	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("customerId", customer.getCustomerId());
		paramMap.put("firstName", customer.getFirstName());
		paramMap.put("lastName", customer.getLastName());
		paramMap.put("mobile", customer.getMobile());
		paramMap.put("email", customer.getEmail());
		paramMap.put("age", customer.getAge());
		npJdbcTemplate.update(CustomerDaoImpl.UPDATE_CUSTOMER, paramMap);
	}


	@Override
	@Transactional(readOnly = true)
	public Integer getCustomerCount() {
		return npJdbcTemplate.queryForObject(GET_CUSTOMER_COUNT, new MapSqlParameterSource(), Integer.class);
	}


	@Override
	@Transactional(readOnly = true)
	public Double getAverageCustomerAge() {
		
		return npJdbcTemplate.queryForObject(GET_AVERAGE_CUSTOMER_AGE, new MapSqlParameterSource(), Double.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> getAllCustomerNames() {
		List<String> names = new ArrayList<String>();
		
		HashMap<Integer, String> idNamesMap = npJdbcTemplate.query("SELECT CUSTOMER_ID, FIRST_NAME, LAST_NAME FROM CUSTOMER", new ResultSetExtractor<HashMap<Integer, String>>() {

			@Override
			public HashMap<Integer, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				HashMap<Integer, String> namesMap = new HashMap<Integer, String>();
				while(rs.next()) {
					Integer customerId = rs.getInt("CUSTOMER_ID");
					String firstName = rs.getString("FIRST_NAME");
					String lastName = rs.getString("LAST_NAME");
					namesMap.put(customerId, firstName + " " + lastName);
				}
				return namesMap;
			}
			
		});
		idNamesMap.forEach((key,value) -> names.add(value));
		return names;
	}


	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getAllCustomerIdNames() {
		/*
		 * 
		 * {CUSTOMER_ID=102, FIRST_NAME=Rohit, LAST_NAME=Sharma}
		 * {CUSTOMER_ID=101, FIRST_NAME=Virat, LAST_NAME=Kohli}
		 * 
		 */
		return npJdbcTemplate.queryForList("SELECT CUSTOMER_ID, FIRST_NAME, LAST_NAME FROM CUSTOMER", new MapSqlParameterSource());
	}


	@Override
	@Transactional(readOnly = true)
	public List<Integer> getAllCustomerAge() {
		/*
		 * {101,102}
		 */
		return npJdbcTemplate.queryForList("SELECT CUSTOMER_ID FROM CUSTOMER", new MapSqlParameterSource(), Integer.class);
	}

	
	
}
