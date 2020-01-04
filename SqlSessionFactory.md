
### SqlSessionFactory

public interface SqlSessionFactory {
  SqlSession openSession();
  SqlSession openSession(boolean autoCommit);
  SqlSession openSession(Connection connection);
  SqlSession openSession(TransactionIsolationLevel level);
  SqlSession openSession(ExecutorType execType);
  SqlSession openSession(ExecutorType execType, boolean autoCommit);
  SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level);
  SqlSession openSession(ExecutorType execType, Connection connection);
  Configuration getConfiguration();
}


#### DefaultSqlSessionFactory 

openSessionFromDataSource
	TransactionFactory transactionFactory = getTransactionFactoryFromEnvironment(environment);
	Transaction tx = transactionFactory.newTransaction(environment.getDataSource(), level, autoCommit);
	Executor executor = configuration.newExecutor(tx, execType);
	return new DefaultSqlSession(configuration, executor, autoCommit);



TransactionFactory transactionFactory = getTransactionFactoryFromEnvironment(environment);

if (environment == null || environment.getTransactionFactory() == null) {
  return new ManagedTransactionFactory();
}
return environment.getTransactionFactory();
