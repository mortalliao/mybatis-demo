package com.sourcecode.learning.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sourcecode.learning.mybatis.dao.UserDao;
import com.sourcecode.learning.mybatis.entity.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	// 获取sqlSession
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession(true);
	}

	@Override
	public User queryUserById(Long id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("userDao.queryUserById", id);
	}

	@Override
	public List<User> queryUsers() {
		return getSqlSession().selectList("userDao.queryUsers");
	}

	@Override
	public void saveUser(User user) {
		getSqlSession().insert("userDao.saveUser", user);
	}

	@Override
	public void updateUser(User user) {
		getSqlSession().update("userDao.updateUser", user);
	}

	@Override
	public void deleteUserById(Long id) {
		getSqlSession().delete("userDao.deleteUserById", id);
	}

}
