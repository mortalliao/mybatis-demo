
```
String resource = "mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

SqlSession sqlSession = sqlSessionFactory.openSession(true);

//使用动态代理获取接口的实现类
dynamicMapper = sqlSession.getMapper(DynamicMapper.class);
```

### SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

在build的时候
XMLConfigBuilder parser = new XMLConfigBuilder(InputStream inputStream, String environment, Properties props);
Configuration config = parser.parse();
return build(config);


private XMLConfigBuilder(XPathParser parser, String environment, Properties props) {
    super(new Configuration());
    ...
}


parser.parse()

parseConfiguration(parser.evalNode("/configuration"));

> 
properties
settings
typeAliases
plugins
objectFactory
objectWrapperFactory
reflectorFactory
environments
databaseIdProvider
typeHandlers
mappers


public SqlSessionFactory build(Configuration config) {
	return new DefaultSqlSessionFactory(config);
}


### SqlSession sqlSession = sqlSessionFactory.openSession(true);






openSessionFromConnection








