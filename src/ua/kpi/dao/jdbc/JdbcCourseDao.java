package ua.kpi.dao.jdbc;

import org.apache.log4j.Logger;
import ua.kpi.dao.CourseDao;
import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements CourseDao interface
 *
 * Created by Сергей on 28.07.2016.
 */
public class JdbcCourseDao implements CourseDao {

    @Override
    public List<Course> findAll() {
        List<Course> res = new ArrayList<>();
        try (Connection connection = JdbcDaoFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(MysqlQuery.FIND_ALL_COURSES);
            while (rs.next()) {
                Teacher teacher = new Teacher(
                                        rs.getInt(ColumnName.ID_TEACHER),
                                        rs.getString(ColumnName.NAME),
                                        rs.getString(ColumnName.LOGIN),
                                        rs.getString(ColumnName.PASSWORD));
                res.add(
                        new Course(rs.getInt(1),
                                rs.getString(ColumnName.COURSE),
                                teacher,
                                rs.getDate(ColumnName.START_DATE),
                                rs.getDate(ColumnName.END_DATE)));
            }
            stmt.close();
        } catch (SQLException e) {
            Logger logger =  Logger.getLogger(JdbcCourseDao.class);
            logger.error(ErrorMessage.FIND_ALL_COURSES + e );
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public Course find(int id) {
        Course res = null;
        try (Connection connection = JdbcDaoFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_COURSE_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getInt(ColumnName.ID_TEACHER),
                        rs.getString(ColumnName.NAME),
                        rs.getString(ColumnName.LOGIN),
                        rs.getString(ColumnName.PASSWORD));
                res = new Course(rs.getInt(1),
                        rs.getString(ColumnName.COURSE),
                        teacher,
                        rs.getDate(ColumnName.START_DATE),
                        rs.getDate(ColumnName.END_DATE));
            }
            stmt.close();
        } catch (SQLException e) {
            Logger logger =  Logger.getLogger(JdbcCourseDao.class);
            logger.error(ErrorMessage.FIND_COURSE + e );
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public void create(Course course) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Course course) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
