package ua.kpi.dao.jdbc;

import ua.kpi.dao.UserDao;
import ua.kpi.model.entities.Student;
import ua.kpi.model.entities.Teacher;
import ua.kpi.model.entities.User;

import java.sql.*;
import java.util.List;

/**
 * Created by Сергей on 28.07.2016.
 */
public class JdbcUserDao implements UserDao {

    @Override
    public boolean isUserExist(String login, String password) {
        boolean isExist = false;
        try (Connection connection = JdbcDaoFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_USER);
            stmt.setNString(1, login);
            stmt.setNString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }

    @Override
    public User logIn(String login, String password) {
        User user = null;
        try (Connection connection = JdbcDaoFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_USER);
            stmt.setNString(1, login);
            stmt.setNString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User.Status status = User.Status.valueOf(rs.getString("status"));
                switch (status) {
                    case STUDENT:
                        user = new Student(rs.getInt(1),
                                rs.getNString("name"),
                                rs.getNString("login"),
                                rs.getNString("password"));
                        break;
                    case TEACHER:
                        user = new Teacher(rs.getInt(1),
                                rs.getNString("name"),
                                rs.getNString("login"),
                                rs.getNString("password"));
                        break;
                    default:
                        //todo: something
                        System.out.println("UserDao fail");
                        return null;
                }
            } else {
                //todo: user does not exist
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) {

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
