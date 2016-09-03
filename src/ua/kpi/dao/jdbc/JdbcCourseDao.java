package ua.kpi.dao.jdbc;

import org.apache.log4j.Logger;
import ua.kpi.dao.CourseDao;
import ua.kpi.dao.jdbc.constants.ColumnName;
import ua.kpi.dao.jdbc.constants.ErrorMessage;
import ua.kpi.dao.jdbc.constants.MysqlQuery;
import ua.kpi.entities.Course;
import ua.kpi.entities.Teacher;

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
    	try(Connection connection = JdbcDaoFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.CREATE_COURSE);
            stmt.setString(1,course.getCourseName());
            stmt.setInt(2, course.getCourseTeacher().getId());
            stmt.setDate(3, (Date) course.getStartDate());
            stmt.setDate(4, (Date) course.getEndDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger logger =  Logger.getLogger(JdbcCourseDao.class);
            logger.error(ErrorMessage.CREATE_COURSE_MEMBER + e );
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Course course) {
    	int update;
    	try(Connection connection = JdbcDaoFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.UPDATE_COURSE);
            stmt.setString(1,course.getCourseName());
            stmt.setInt(2, course.getCourseTeacher().getId());
            stmt.setDate(3, (Date) course.getStartDate());
            stmt.setDate(4, (Date) course.getEndDate());
            stmt.setInt(5, course.getId());
            update = stmt.executeUpdate();
        } catch (SQLException e) {
            Logger logger =  Logger.getLogger(JdbcCourseDao.class);
            logger.error(ErrorMessage.CREATE_COURSE_MEMBER + e );
            throw new RuntimeException(e);
        }
    	return (update > 0);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
