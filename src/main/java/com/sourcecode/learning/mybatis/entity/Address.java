package com.sourcecode.learning.mybatis.entity;

import lombok.Data;

@Data
public class Address {

	private Long addressId;
	private Long stuId;
	private String country;
	private String province;
	private String city;
	private String district;
	private String street;
	private String postCode;
	
}
