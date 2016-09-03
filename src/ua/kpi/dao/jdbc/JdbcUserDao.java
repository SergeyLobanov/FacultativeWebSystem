package ua.kpi.dao.jdbc;


import ua.kpi.dao.UserDao;
import ua.kpi.dao.jdbc.constants.ColumnName;
import ua.kpi.dao.jdbc.constants.ErrorMessage;
import ua.kpi.dao.jdbc.constants.MysqlQuery;
import ua.kpi.entities.Student;
import ua.kpi.entities.Teacher;
import ua.kpi.entities.User;

import java.sql.*;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Implements UserDao interface
 *
 * Created by Сергей on 28.07.2016.
 */
public class JdbcUserDao implements UserDao {


    @Override
    public void create(User user) {
    	try (Connection connection = JdbcDaoFactory.getConnection()) {
            PreparedStatement stmt;
            User.Status status = user.getStatus();
            switch (status) {
                case STUDENT:
                	stmt = connection.prepareStatement(MysqlQuery.CREATE_STUDENT);
                    break;
                case TEACHER:
                	stmt = connection.prepareStatement(MysqlQuery.CREATE_TEACHER);
                    break;
                default:
                    Logger logger =  Logger.getLogger(JdbcUserDao.class);
                    logger.error(ErrorMessage.WRONG_STATUS);
                    throw new RuntimeException();
            }          
            stmt.setString(1, user.getName());           
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
    	} catch (SQLException e) {
            System.err.println(e);
            Logger logger =  Logger.getLogger(JdbcUserDao.class);
            logger.error(ErrorMessage.USER_CREATE + e );
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public User logIn(String login, String password) {
        User user = null;
        try (Connection connection = JdbcDaoFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_USER);
            stmt.setString(1, login);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User.Status status = User.Status.valueOf(rs.getString(ColumnName.STATUS));
                switch (status) {
                    case STUDENT:
                        user = new Student(rs.getInt(1),
                                rs.getNString(ColumnName.NAME),
                                rs.getNString(ColumnName.LOGIN),
                                rs.getNString(ColumnName.PASSWORD));
                        break;
                    case TEACHER:
                        user = new Teacher(rs.getInt(1),
                                rs.getNString(ColumnName.NAME),
                                rs.getNString(ColumnName.LOGIN),
                                rs.getNString(ColumnName.PASSWORD));
                        break;
                    default:
                        return user;
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            Logger logger =  Logger.getLogger(JdbcUserDao.class);
            logger.error(ErrorMessage.USER_LOGIN + e );
            throw new RuntimeException(e);
        }
        return user;
    }

	@Override
	public boolean isLoginExist(String login) {
		try (Connection connection = JdbcDaoFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.VERIFY_LOGIN);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	return true;
            }
        } catch (SQLException e) {
            Logger logger =  Logger.getLogger(JdbcUserDao.class);
            logger.error(ErrorMessage.USER_LOGIN + e );
            throw new RuntimeException(e);
        }
        return false;
	}

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
