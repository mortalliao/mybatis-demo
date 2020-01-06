
### StatementHandler

public interface StatementHandler {

  Statement prepare(Connection connection, Integer transactionTimeout) throws SQLException;
  void parameterize(Statement statement) throws SQLException;
  void batch(Statement statement) throws SQLException;
  int update(Statement statement) throws SQLException;
  <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;
  <E> Cursor<E> queryCursor(Statement statement) throws SQLException;
  BoundSql getBoundSql();
  ParameterHandler getParameterHandler();
}

#### BaseStatementHandler

- CallableStatementHandler
- PreparedStatementHandler
- SimpleStatementHandler



#### RoutingStatementHandler




