package ua.kpi.dao.jdbc.constants;

/**
 * Interface consists column names of mysql database
 *
 * Created by Сергей on 05.08.2016.
 */
public interface ColumnName {
    String ID_TEACHER = "id_teacher";
    String NAME = "name";
    String LOGIN = "login";
    String PASSWORD = "password";
    String COURSE = "course";
    String START_DATE = "start_date";
    String END_DATE = "end_date";
    String TEACHER_NAME = "t.name";
    String TEACHER_LOGIN = "t.login";
    String TEACHER_PASSWORD = "t.password";
    String ID_STUDENT = "id_student";
    String STUDENT_NAME = "s.name";
    String STUDENT_LOGIN = "s.login";
    String STUDENT_PASSWORD = "s.password";
    String ID_COURSE = "id_course";
    String MARK = "mark";
    String COMMENT = "comment";
    String STATUS = "status";
}
