package com.sourcecode.learning.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7591167926253352944L;
	private Long id;
	private String account;
	private String password;
	private String userName;
	private Integer gender;
	private Integer age;
	private Date birthday;
	private Date createTime;

}
