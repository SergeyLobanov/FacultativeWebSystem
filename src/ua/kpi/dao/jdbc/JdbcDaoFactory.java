package ua.kpi.dao.jdbc;

import ua.kpi.dao.CourseDao;
import ua.kpi.dao.CourseMemberDao;
import ua.kpi.dao.DaoFactory;
import ua.kpi.dao.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Сергей on 27.07.2016.
 */
public class JdbcDaoFactory extends DaoFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/facultative" +
            "?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    //private static DataSource ds;
    //todo: @ createSOmeDao() methods

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

    public JdbcDaoFactory() {
    	try {
    	    Class.forName("com.mysql.jdbc.Driver");
    	    //System.out.println("ok");
    	
    	} catch (ClassNotFoundException e) {
            //todo: make norm
    	    System.out.println("Where is your MySQL JDBC Driver?");
    	    e.printStackTrace();
    	}
    	/*try {
            InitialContext ic = new InitialContext();

            ds = (DataSource) ic.lookup("java:comp/env/jdbc/facultative");
        } catch (NamingException e) {
            e.printStackTrace();
        }*/
    }
    

    public static Connection getConnection() throws SQLException {
        //return ds.getConnection();
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
