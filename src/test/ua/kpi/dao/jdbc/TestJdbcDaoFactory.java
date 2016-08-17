package test.ua.kpi.dao.jdbc;

import ua.kpi.dao.CourseDao;
import ua.kpi.dao.CourseMemberDao;
import ua.kpi.dao.DaoFactory;
import ua.kpi.dao.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import ua.kpi.dao.jdbc.JdbcCourseDao;
import ua.kpi.dao.jdbc.JdbcCourseMemberDao;
import ua.kpi.dao.jdbc.JdbcUserDao;
import ua.kpi.dao.jdbc.constants.ErrorMessage;

/**
 * Extends DaoFactory class.
 * Creates connection via DataSource and JdbcDaos
 *
 * Created by Сергей on 27.07.2016.
 */
public class TestJdbcDaoFactory extends DaoFactory {
	
    private static final String URL = "jdbc:mysql://localhost:3306/facultative" +
            "?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public TestJdbcDaoFactory() {
    	try {
    	    Class.forName("com.mysql.jdbc.Driver");
    	
    	} catch (ClassNotFoundException e) {
    	    e.printStackTrace();
    	}
    	
    }


    /**
     * gets connection to database
     * @return connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @Override
    public UserDao createUserDao() {
        return new JdbcUserDao();
    }

    @Override
    public CourseDao createCourseDao() {
        return new JdbcCourseDao();
    }

    @Override
    public CourseMemberDao createCourseMemberDao() {
        return new JdbcCourseMemberDao();
    }
}
