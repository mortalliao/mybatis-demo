package com.sourcecode.learning.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.sourcecode.learning.mybatis.entity.Grade;
import com.sourcecode.learning.mybatis.entity.Student;
import com.sourcecode.learning.mybatis.entity.StudentAddress;

public interface StudentMapper {

	/**
	 * 根据学生ID查询学生信息包括学生的地址
	 */
	public StudentAddress queryStudentAndAddressByStuId(@Param("stuId") Long stuId);

	/**
	 * 根据学生ID查询学生信息包括学生的地址
	 */
	public Student queryStudentByStuId(@Param("stuId") Long stuId);

	/* 根据年级ID查询该年级信息包括该年级的所有学生 */
	public Grade queryGradeAndStudentByGradeId(@Param("gradeId") Long gradeId);

	/* 根据学生ID查询学生信息包括学生的地址及其学习的课程 */
	public Student queryStuAndAddressAndCoursesByStuId(@Param("stuId") Long stuId);

	// 根据学生ID查询学生信息包括延迟加载学生的年级；即调用学生对象中的获取年级的方法时才去执行查询年级的SQL。
	public Student lazyQueryStudentAndGradeByStuId(@Param("stuId") Long stuId);

}
