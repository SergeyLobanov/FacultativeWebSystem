package ua.kpi.dao.jdbc;

import org.apache.log4j.Logger;
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
    public CourseMember find(int courseMemberId) {
        CourseMember courseMember = null;
        try (Connection connection = JdbcDaoFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_COURSE_MEMBER_BY_ID);
            stmt.setInt(1, courseMemberId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getInt(ColumnName.ID_TEACHER),
                        rs.getString(ColumnName.TEACHER_NAME),
                        rs.getString(ColumnName.TEACHER_LOGIN),
                        rs.getString(ColumnName.TEACHER_PASSWORD));
                Student student = new Student(
                        rs.getInt(ColumnName.ID_STUDENT),
                        rs.getString(ColumnName.STUDENT_NAME),
                        rs.getString(ColumnName.STUDENT_LOGIN),
                        rs.getString(ColumnName.STUDENT_PASSWORD));
                Course course = new Course(
                        rs.getInt(ColumnName.ID_COURSE),
                        rs.getString(ColumnName.COURSE),
                        teacher,
                        rs.getDate(ColumnName.START_DATE),
                        rs.getDate(ColumnName.END_DATE));
                courseMember = new CourseMember(
                        rs.getInt(1),
                        course,
                        student,
                        rs.getInt(ColumnName.MARK),
                        rs.getString(ColumnName.COMMENT));
            }
            stmt.close();
        } catch (SQLException e) {
            Logger logger =  Logger.getLogger(JdbcCourseMemberDao.class);
            logger.error(ErrorMessage.FIND_COURSE_MEMBER_BY_ID + e );
            throw new RuntimeException(e);
        }
        return courseMember;
    }

    @Override
    public List<CourseMember> findByTeacherID(int id) {
        List<CourseMember> courseMembers;
        try (Connection connection = JdbcDaoFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_STUDENTS_OF_TEACHER_BY_ID);
            stmt.setInt(1, id);
            courseMembers = getCourseMembersByQuery(stmt);
        } catch (SQLException e) {
            Logger logger =  Logger.getLogger(JdbcCourseMemberDao.class);
            logger.error(ErrorMessage.COURSE_MEMBERS_OF_TEACHER + e );
            throw new RuntimeException(e);
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
            Logger logger =  Logger.getLogger(JdbcCourseMemberDao.class);
            logger.error(ErrorMessage.CREATE_COURSE_MEMBER + e );
            throw new RuntimeException(e);
        }
    }

    @Override
    public CourseMember find(Student student, int courseId) {
        //todo: maybe don't need
        CourseMember courseMember = null;
        try (Connection connection = JdbcDaoFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(MysqlQuery.FIND_COURSE_MEMBER);
            stmt.setInt(1, courseId);
            stmt.setInt(2, student.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getInt(ColumnName.ID_TEACHER),
                        rs.getString(ColumnName.TEACHER_NAME),
                        rs.getString(ColumnName.TEACHER_LOGIN),
                        rs.getString(ColumnName.TEACHER_PASSWORD));
                Course course = new Course(
                        courseId,
                        rs.getString(ColumnName.COURSE),
                        teacher,
                        rs.getDate(ColumnName.START_DATE),
                        rs.getDate(ColumnName.END_DATE));
                courseMember = new CourseMember(
                        rs.getInt(1),
                        course,
                        student,
                        rs.getInt(ColumnName.MARK),
                        rs.getString(ColumnName.COMMENT));
            }
            stmt.close();
        } catch (SQLException e) {
            Logger logger =  Logger.getLogger(JdbcCourseMemberDao.class);
            logger.error(ErrorMessage.FIND_COURSE_MEMBER_BY_STUDENT_AND_COURSE_ID+ e );
            throw new RuntimeException(e);
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
            Logger logger =  Logger.getLogger(JdbcCourseMemberDao.class);
            logger.error(ErrorMessage.FIND_COURSE_MEMBERS_WITH_STUDENT_BY_ID + e );
            throw new RuntimeException(e);
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
                    rs.getInt(ColumnName.ID_TEACHER),
                    rs.getString(ColumnName.TEACHER_NAME),
                    rs.getString(ColumnName.TEACHER_LOGIN),
                    rs.getString(ColumnName.TEACHER_PASSWORD));
            Student student = new Student(
                    rs.getInt(ColumnName.ID_STUDENT),
                    rs.getString(ColumnName.STUDENT_NAME),
                    rs.getString(ColumnName.STUDENT_LOGIN),
                    rs.getString(ColumnName.STUDENT_PASSWORD));
            Course course = new Course(
                    rs.getInt(ColumnName.ID_COURSE),
                    rs.getString(ColumnName.COURSE),
                    teacher,
                    rs.getDate(ColumnName.START_DATE),
                    rs.getDate(ColumnName.END_DATE));
            res.add(new CourseMember(rs.getInt(1),
                    course,
                    student,
                    rs.getInt(ColumnName.MARK),
                    rs.getString(ColumnName.COMMENT)));
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
            Logger logger =  Logger.getLogger(JdbcCourseMemberDao.class);
            logger.error(ErrorMessage.UPDATE_COURSE_MEMBER + e );
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
    public List<CourseMember> findAll() {
        return null;
    }
}
