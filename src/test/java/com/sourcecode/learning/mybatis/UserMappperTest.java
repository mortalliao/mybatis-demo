package com.sourcecode.learning.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sourcecode.learning.mybatis.entity.User;
import com.sourcecode.learning.mybatis.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserMappperTest {

	private UserMapper userMapper;
	private SqlSession sqlSession;

	@Before
	public void before() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession();

		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@After
	public void after() {
		// 更新必须要提交事务
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test() {
		/*
		 * User login(@Param("account") String account, @Param("password") String
		 * password);
		 */
		User loginUser1 = userMapper.login("account", "password");
		System.out.println(loginUser1);

		System.out.println("------------------------------------");

		/*
		 * User login2(User user);
		 */
		User loginUser = new User();
		loginUser.setAccount("account");
		loginUser.setPassword("password");
		User loginUser2 = userMapper.login2(loginUser);
		System.out.println(loginUser2);

		System.out.println("------------------------------------");

		/*
		 * User login3(Map<String, String> map);
		 */
		Map<String, String> map = new HashMap<>();
		map.put("account", "account");
		map.put("password", "password");
		User loginUser3 = userMapper.login3(map);
		System.out.println(loginUser3);

		System.out.println("------------------------------------");

		/*
		 * Map<String, Object> login4
		 * (@Param("account") String account, @Param("password") String password);
		 */
		Map<String, Object> loginUser4 = userMapper.login4("account", "password");
		Set<Entry<String, Object>> entrySet = loginUser4.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}

		System.out.println("------------------------------------");

		/*
		 * User queryUserById(@Param("id") Long id);
		 */
		User resultMap = userMapper.queryUserById(1L);
		System.out.println(resultMap);

		System.out.println("------------------------------------");

		/*
		 * List<User> queryMaleUserByUserName(@Param("userName") String userName);
		 */
		List<User> ifList = userMapper.queryMaleUserByUserName("");
		for (User user : ifList) {
			System.out.println(user);
		}

		System.out.println("------------------------------------");

		/*
		 * List<User> queryUserByGender(@Param("gender") int gender);
		 */
		List<User> chooseWhenOtherwise = userMapper.queryUserByGender(1);
		for (User user : chooseWhenOtherwise) {
			System.out.println(user);
		}

		System.out.println("------------------------------------");

		/*
		 * List<User> queryUserByUserNameAndGender
		 * (@Param("userName") String userName, @Param("gender") Integer gender);
		 */
		List<User> where = userMapper.queryUserByUserNameAndGender("admin", 1);
		for (User user : where) {
			System.out.println(user);
		}

		System.out.println("------------------------------------");

		/*
		 * void updateUserSelective(User user);
		 * 
		 *  默认情况下，mybatis 的 update 操作返回值是记录的 matched 的条数，并不是影响的记录条数。
		 */
		User updateUser = new User();
		updateUser.setId(1L);
		updateUser.setUserName("admin");
		int set = userMapper.updateUserSelective(updateUser);
		System.out.println(set);

		/*
		 * List<User> queryUsersByIds(@Param("ids") Long[] ids);
		 */
		List<User> foreach = userMapper.queryUsersByIds(new Long[] { 1l });
		for (User user : foreach) {
			System.out.println(user);
		}

	}

}
