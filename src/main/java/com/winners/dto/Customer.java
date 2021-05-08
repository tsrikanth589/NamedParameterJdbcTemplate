package com.winners.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String mobile;
	private String email;
	private List<Address> addressList;
}
