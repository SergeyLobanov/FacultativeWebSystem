package test.ua.kpi.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import ua.kpi.dao.jdbc.JdbcDaoFactory;

public class JdbcDaoFactoryTest {

	@Test
	public void testCreateDaoFactory() {
		TestJdbcDaoFactory daoFactory = new TestJdbcDaoFactory();
		
		Assert.assertNotNull(daoFactory);
	}
	
	@Test
	public void testGetConnection() throws SQLException {
		TestJdbcDaoFactory daoFactory = new TestJdbcDaoFactory();
		Connection connection = daoFactory.getConnection();
		
		Assert.assertNotNull(connection);
	}
	
}