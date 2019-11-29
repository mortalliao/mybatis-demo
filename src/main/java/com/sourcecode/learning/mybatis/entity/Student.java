package com.sourcecode.learning.mybatis.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Student {

	private Long stuId;
	private Long gradeId;
	private String stuName;
	private Integer gender;
	private Integer age;
	private Date birthday;

	private Address address;

	private List<Course> courses;

	private Grade grade;

}
