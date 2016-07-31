package ua.kpi.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
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
        throw new NotImplementedException();
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
        List<Course> res = new ArrayList<>();
        try (Connection connection = JdbcDaoFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(MysqlQuery.FIND_ALL_COURSES);
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
        } catch (SQLException e) {
            Logger logger =  LogManager.getLogger(JdbcCourseDao.class);
            logger.error("Finding all courses error" + e );
        }
        return res;
    }

}
