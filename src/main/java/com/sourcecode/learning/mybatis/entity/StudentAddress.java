package com.sourcecode.learning.mybatis.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentAddress extends Student {

	private Long addressId;
	private Long stuId;
	private String country;
	private String province;
	private String city;
	private String district;
	private String street;
	private String postCode;

}
