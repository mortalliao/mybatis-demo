package com.sourcecode.learning.mybatis.entity;

import java.util.List;

import lombok.Data;

@Data
public class Grade {

	private Long gradeId;
	private String name;

	private List<Student> students;

}
