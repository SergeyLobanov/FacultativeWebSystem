package ua.kpi.dao.test;

import ua.kpi.dao.jdbc.JdbcDaoFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Hashtable;

/**
 * Created by Сергей on 27.07.2016.
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
    	Connection myConn = null;
		DataSource ds = null;
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("jdbc/FacultativeDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		try /*(Connection myConn = JdbcDaoFactory.getConnection())*/{
//			Connection myConn = DriverManager
//					.getConnection("jdbc:mysql://localhost:3306/facultative" +
//							"?autoReconnect=true&useSSL=false","root", "root");

//    		System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
//                     "org.apache.naming.java.javaURLContextFactory");
//			InitialContext ic = new InitialContext();
//    		Hashtable env = new Hashtable();
//    		env.put(Context.INITIAL_CONTEXT_FACTORY,
//                    "org.apache.naming.java.javaURLContextFactory");
//    		env.put(Context.PROVIDER_URL, "ldap://ldap.wiz.com:389");
//    		env.put(Context.SECURITY_PRINCIPAL, "root");
//    		env.put(Context.SECURITY_CREDENTIALS, "root");

    		//Context ctx = new InitialContext(env);
			//DataSource	ds = (DataSource) ic.lookup("java:/comp/env/jdbc/FacultativeDB");
			//Connection myConn = ds.getConnection();
			Statement stmt = myConn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students");
			while (rs.next()) {
				String userid = rs.getString(1);
				String username = rs.getString(2);

				System.out.print("id : " + userid);
				System.out.println(" username : " + username);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

    	/*it is ok
		try {
    	    Class.forName("com.mysql.jdbc.Driver");
    	    System.out.println("ok");
    	
    	} catch (ClassNotFoundException e) {
    	    System.out.println("Where is your MySQL JDBC Driver?");
    	    e.printStackTrace();
    	    return;
    	}

    	try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/facultative","root", "root")) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }*/
    	
		/*
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("jdbc/facultative");

		Connection con = dataSource.getConnection("root","root");

		//Connection conn = dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from students");

		// И если что то было получено то цикл while сработает
		while (rs.next()) {
			String userid = rs.getString(1);
			String username = rs.getString(2);

			System.out.println("id : " + userid);
			System.out.println("username : " + username);
		}
		//...
		rs.close();
		stmt.close();
		con.close();*/
        /*
        try {
            Statement statement = conn.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery("select * from students");

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String userid = rs.getString(1);
                String username = rs.getString(2);

                System.out.println("id : " + userid);
                System.out.println("username : " + username);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
        */
    }
}
