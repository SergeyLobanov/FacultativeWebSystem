package test.ua.kpi.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.kpi.dao.DaoFactory;
import ua.kpi.dao.UserDao;
import ua.kpi.dao.jdbc.JdbcDaoFactory;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

/**
 * Created by Сергей on 13.08.2016.
 */
public class JdbcUserDaoTest {
	private UserDao userDao;
	private Connection connection;
    
	@BeforeClass
	public static void setUpTest() {
		try {
    	    Class.forName("com.mysql.jdbc.Driver");
    	
    	} catch (ClassNotFoundException e) {
    	    e.printStackTrace();
    	}
	}
	
	@Before
	public void setUp() throws SQLException {
		DaoFactory factory = new TestJdbcDaoFactory();
		userDao = factory.createUserDao();
		connection = TestJdbcDaoFactory.getConnection();
		connection.setAutoCommit(false);
	}
	
	@After
	public void tearDown() throws SQLException {
		connection.rollback();
		connection.close();
	}
	
	@Test
	public void testLoginWithExistedUser() {
		String login = "lobanov";
		String password = "ba8eb0a49d579f7ac8ac53bda569ebfc";
		JdbcDaoFactory mockJdbcDF = mock(JdbcDaoFactory.class);
		//when(TestJdbcDaoFactory.getConnection()).return(connection);
		Assert.assertNotNull(userDao.logIn(login, password));
		
	}
	
	@Test
	public void test() {
//		DaoFactory factory = DaoFactory.getFactory();
//      UserDao userDao = factory.createUserDao();
		
		Assert.assertNotNull(connection);
	}
	
	/*
	@Before
	public void setUpUserDao() throws SQLException {
		userDao = factory.createUserDao();
		connection = JdbcDaoFactory.getConnection();
		connection.setAutoCommit(false);
	}
	
	@After
	public void tearDownUserDao() throws SQLException {
		connection.rollback();
		userDao = null;
	}
	
	@Test
	public void testLogIn() {
		String userLogin = "lobanov";
		String userPassword = "lobanov";
		User user = null;
		user = userDao.logIn(userLogin, userPassword);
		Assert.assertNotNull(user);
	}*/
}
