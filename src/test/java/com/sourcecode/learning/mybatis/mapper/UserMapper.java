package com.sourcecode.learning.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sourcecode.learning.mybatis.entity.User;

public interface UserMapper {

	// 登录
	public User login(@Param("account") String account, @Param("password") String password);

	// 登录
	public User login2(User user);

	// 登录
	public User login3(Map<String, String> map);

	// 登录
	public Map<String, Object> login4(@Param("account") String account, @Param("password") String password);

	// 根据id查询
	public User queryUserById(@Param("id") Long id);

	// 查询男性用户；如果用户名不为空的话则再根据用户名查询。
	public List<User> queryMaleUserByUserName(@Param("userName") String userName);

	/**
	 * 根据性别查询用户：如果是男，则需要再查询年龄大于等于15岁的；如果是女，则需要再查询年龄大于等于14岁的。
	 */
	public List<User> queryUserByGender(@Param("gender") int gender);

	/**
	 * 根据用户名和性别查询用户；当性别的值不是1或者0时，设置查询的性别的值为-1。
	 */
	public List<User> queryUserByUserNameAndGender(@Param("userName") String userName, @Param("gender") Integer gender);

	// 更新用户
	public int updateUserSelective(User user);

	// 根据用户的ID集合查询用户列表
	public List<User> queryUsersByIds(@Param("ids") Long[] ids);
}
