package ua.kpi.dao.jdbc;


import ua.kpi.dao.UserDao;
import ua.kpi.dao.jdbc.constants.ColumnName;
import ua.kpi.dao.jdbc.constants.ErrorMessage;
import ua.kpi.dao.jdbc.constants.MysqlQuery;
import ua.kpi.model.entities.Student;
import ua.kpi.model.entities.Teacher;
import ua.kpi.model.entities.User;

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
    public User logIn(String login, String password) {
        User user = null;
        try (Connection connection = JdbcDaoFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_USER);
            stmt.setNString(1, login);
            stmt.setNString(2, password);

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
    public void create(User user) {
        throw new UnsupportedOperationException();
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
