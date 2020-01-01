package com.sourcecode.learning.mybatis;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.sourcecode.learning.mybatis.mapper.DynamicMapper;

public class DynamicMapperTest {

	private DynamicMapper dynamicMapper;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "");
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		//使用动态代理获取接口的实现类
		dynamicMapper = sqlSession.getMapper(DynamicMapper.class);
	}

	
	@Test
	public void testQueryByTableName() {
		List<Map<String,Object>> list = dynamicMapper.queryByTableName("t_user");
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
}