package com.winners.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
	private Integer addressId;
	private String address;
	private String addressType;
	private Integer customerId;
}
