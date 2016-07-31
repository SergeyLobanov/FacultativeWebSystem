package ua.kpi.dao.jdbc;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Extends DaoFactory class.
 * Creates connection via DataSource and JdbcDaos
 *
 * Created by Сергей on 27.07.2016.
 */
public class JdbcDaoFactory extends DaoFactory {
	/*
    private static final String URL = "jdbc:mysql://localhost:3306/facultative" +
            "?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
*/
    /**
     * data source for connection to database
     */
    private static DataSource ds;

    public JdbcDaoFactory() {
    	try {
            InitialContext ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/FacultativeDB");
        } catch (NamingException e) {
            Logger logger =  LogManager.getLogger(JdbcDaoFactory.class);
            logger.error("Dao Factory creating error: " + e );
        }
    	/*
    	try {
    	    Class.forName("com.mysql.jdbc.Driver");
    	    //System.out.println("ok");
    	
    	} catch (ClassNotFoundException e) {
    	    e.printStackTrace();
    	}
    	*/
    }


    /**
     * gets connection to database
     * @return connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
        //return DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
