package ua.kpi.dao.jdbc;

import ua.kpi.dao.CourseDao;
import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 28.07.2016.
 */
public class JdbcCourseDao implements CourseDao {
    @Override
    public void create(Course course) {

    }

    @Override
    public boolean update(Course course) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Course find(int id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        try (Connection connection = JdbcDaoFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(MysqlQuery.FIND_ALL_COURSES);
            List<Course> res = new ArrayList<>();
            while (rs.next()) {
                Teacher teacher = new Teacher(
                                        rs.getInt("id_teacher"),
                                        rs.getString("name"),
                                        rs.getString("login"),
                                        rs.getString("password"));
                res.add(
                        new Course(rs.getInt(1),
                                rs.getString("course"),
                                teacher,
                                rs.getDate("start_date"),
                                rs.getDate("end_date")));
            }
            stmt.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> findAllWithStudent(int id) {
        try (Connection connection = JdbcDaoFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(MysqlQuery.FIND_ALL_COURSES);
            List<Course> res = new ArrayList<>();
            /*while (rs.next()) {
                res.add(new Course(rs.getString("course"),
                        rs.getString("name"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date")));
                /*
                new Course(rs.getInt(1),
                                rs.getString("course"),
                                rs.getInt("id_teacher"),
                                rs.getDate("start_date"),
                                rs.getDate("end_date"))
                 */
            //}
            stmt.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
