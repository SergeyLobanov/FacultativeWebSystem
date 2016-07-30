package ua.kpi.dao.jdbc;

/**
 * Created by Сергей on 28.07.2016.
 */
public interface MysqlQuery {
    String FIND_USER = "SELECT * FROM facultative.users WHERE login = ? and " +
            "password = ?";
    String FIND_ALL_COURSES = "SELECT id_course, course, t.id_teacher, name, " +
            "login, password, start_date, end_date " +
            "FROM courses c JOIN teachers t " +
            "ON c.id_teacher = t.id_teacher";
    String FIND_COURSES_OF_STUDENT_BY_ID = "SELECT id_course_member, " +
            "c.id_course, course, t.id_teacher, t.name, t.login, t.password, " +
            "start_date, end_date, s.id_student, s.name, s.login, " +
            "s.password, mark, comment " +
            "FROM course_members cm " +
            "JOIN courses c ON cm.id_course = c.id_course " +
            "JOIN teachers t ON t.id_teacher = c.id_teacher " +
            "JOIN students s ON cm.id_student = s.id_student " +
            "WHERE s.id_student = ?";
    String CREATE_COURSE_MEMBER = "INSERT INTO course_members " +
            "(id_course, id_student)" +
            "VALUES (?, ?)";
    String UPDATE_COURSE_MEMBER = "UPDATE course_members " +
            "SET mark = ?, comment= ? " +
            "WHERE id_course_member= ?";
    String FIND_COURSE_MEMBER = "SELECT id_course_member, c.id_course, course, " +
            "t.id_teacher, t.name, t.login, t.password, " +
            "start_date, end_date, s.id_student, mark, comment " +
            "FROM course_members cm " +
            "JOIN courses c ON cm.id_course = c.id_course " +
            "JOIN students s ON cm.id_student = s.id_student " +
            "JOIN teachers t ON t.id_teacher = c.id_teacher " +
            "WHERE (c.id_course = ?) AND (s.id_student = ?)";
    String FIND_STUDENTS_OF_TEACHER_BY_ID = "SELECT id_course_member, " +
            "c.id_course, course, t.id_teacher, t.name, t.login, t.password," +
            "start_date, end_date, s.id_student, s.name, s.login, " +
            "s.password, mark, comment " +
            "FROM course_members cm " +
            "JOIN courses c ON cm.id_course = c.id_course " +
            "JOIN students s ON cm.id_student = s.id_student " +
            "JOIN teachers t ON t.id_teacher = c.id_teacher " +
            "WHERE c.id_teacher = ?";
}
