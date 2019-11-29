package com.sourcecode.learning.mybatis.dao;

import java.util.List;

import com.sourcecode.learning.mybatis.entity.User;

public interface UserDao {

	// 根据id查询
	public User queryUserById(Long id);

	// 查询所有
	public List<User> queryUsers();

	// 新增
	public void saveUser(User user);

	// 更新
	public void updateUser(User user);

	// 根据id删除
	public void deleteUserById(Long id);

}
