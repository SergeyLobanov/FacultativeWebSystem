package ua.kpi.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.kpi.dao.CourseMemberDao;
import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.model.entities.Student;
import ua.kpi.model.entities.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements CourseMemberDao interface
 *
 * Created by Сергей on 29.07.2016.
 */
public class JdbcCourseMemberDao implements CourseMemberDao {

    @Override
    public List<CourseMember> findByTeacherID(int id) {
        List<CourseMember> courseMembers = new ArrayList<>();
        try (Connection connection = JdbcDaoFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_STUDENTS_OF_TEACHER_BY_ID);
            stmt.setInt(1, id);
            courseMembers = getCourseMembersByQuery(stmt);
        } catch (SQLException e) {
            Logger logger =  LogManager.getLogger(JdbcCourseMemberDao.class);
            logger.error("Finding course members by teacher id error" + e );
        }
        return courseMembers;
    }

    @Override
    public void create(Student student, int courseId) {
        try(Connection connection = JdbcDaoFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.CREATE_COURSE_MEMBER);
            stmt.setInt(1, courseId);
            stmt.setInt(2, student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger logger =  LogManager.getLogger(JdbcCourseMemberDao.class);
            logger.error("Creating course member error" + e );
        }
    }

    @Override
    public CourseMember find(Student student, int courseId) {
        CourseMember courseMember = null;
        try (Connection connection = JdbcDaoFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_COURSE_MEMBER);
            stmt.setInt(1, courseId);
            stmt.setInt(2, student.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getInt("id_teacher"),
                        rs.getString("t.name"),
                        rs.getString("t.login"),
                        rs.getString("t.password"));
                Course course = new Course(//todo: find course from another dao?
                        courseId,
                        rs.getString("course"),
                        teacher,
                        rs.getDate("start_date"),
                        rs.getDate("end_date"));
                courseMember = new CourseMember(
                        rs.getInt(1),
                        course,
                        student,
                        rs.getInt("mark"),
                        rs.getString("comment"));
            }
            stmt.close();
        } catch (SQLException e) {
            Logger logger =  LogManager.getLogger(JdbcCourseMemberDao.class);
            logger.error("Finding course member by student and course id error" + e );
        }
        return courseMember;
    }

    @Override
    public List<CourseMember> findByStudentID(int id) {
        List<CourseMember> courseMembers = new ArrayList<>();
        try (Connection connection = JdbcDaoFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_COURSES_OF_STUDENT_BY_ID);
            stmt.setInt(1, id);
            courseMembers = getCourseMembersByQuery(stmt);
        } catch (SQLException e) {
            Logger logger =  LogManager.getLogger(JdbcCourseMemberDao.class);
            logger.error("Finding course members by student id error" + e );
        }
        return courseMembers;
    }

    /**
     * gets list of CourseMember by prepared statement
     * @param statement for execute
     * @return found list
     * @throws SQLException
     */
    private List<CourseMember> getCourseMembersByQuery(PreparedStatement statement) throws SQLException {
        ResultSet rs = statement.executeQuery();
        List<CourseMember> res = new ArrayList<>();
        while (rs.next()) {
            Teacher teacher = new Teacher(
                    rs.getInt("id_teacher"),
                    rs.getString("t.name"),
                    rs.getString("t.login"),
                    rs.getString("t.password"));
            Student student = new Student(
                    rs.getInt("id_student"),
                    rs.getString("s.name"),
                    rs.getString("s.login"),
                    rs.getString("s.password"));
            Course course = new Course(
                    rs.getInt("id_course"),
                    rs.getString("course"),
                    teacher,
                    rs.getDate("start_date"),
                    rs.getDate("end_date"));
            res.add(new CourseMember(rs.getInt(1),
                    course,
                    student,
                    rs.getInt("mark"),
                    rs.getString("comment")));
        }
        statement.close();
        return res;
    }

    /**
     * updates info in database about CourseMember
     * @param courseMember raw for upgrade
     * @return true if courseMember is updated
     */
    @Override
    public boolean update(CourseMember courseMember) {
        try (Connection connection = JdbcDaoFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.UPDATE_COURSE_MEMBER);
            int newMark = courseMember.getMark();
            String newComment = courseMember.getComment();
            int courseMemberId = courseMember.getCourseMemberID();
            stmt.setInt(1, newMark);
            stmt.setString(2, newComment);
            stmt.setInt(3, courseMemberId);
            int update = stmt.executeUpdate();
            if (update > 0) {
                return true;
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void create(CourseMember courseMember) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public CourseMember find(int id) {
        return null;
    }

    @Override
    public List<CourseMember> findAll() {
        return null;
    }
}
