package com.sourcecode.learning.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sourcecode.learning.mybatis.entity.User;

public class MybatisTest {

	@Test
	public void getSqlSessionFactoryWithXML() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);

		// WithoutXML
//		DataSource dataSource = DataSourceFactory.getDataSource();
//		TransactionFactory transactionFactory = new JdbcTransactionFactory();
//		Environment environment = new Environment("development", transactionFactory, dataSource);
//		Configuration configuration = new Configuration(environment);
//		configuration.addMapper(BlogMapper.class);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}

	@Test
	public void testMybatis() throws IOException {
		// mybatis的总配置文件路径
		String resource = "mybatis-config.xml";
		// 利用mybatis的Resources工具类获取配置文件输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 利用SqlSessionFactoryBuilder根据mybatis配置文件输入流创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 根据sqlSessionFactory获取SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 持久化操作
		// selectOne 参数1：在映射文件中对应的statement语句（包括文件的空间和语句id）
		// selectOne 参数2：在映射文件中对应的statement语句中对应的输入参数
		User user = sqlSession.selectOne("xxx.queryUserById", 1L);

		System.out.println(user);

		sqlSession.close();
	}

}
