package ua.kpi.dao.jdbc;

import java.io.IOException;

/**
 * Interface consists error messages for database
 *
 * Created by Сергей on 05.08.2016.
 */
public interface ErrorMessage {
    String FIND_ALL_COURSES = "Finding all courses error ";
    String FIND_COURSE = "Finding course error ";
    String FIND_COURSE_MEMBER_BY_ID = "Finding course member by student and course id error ";
    String COURSE_MEMBERS_OF_TEACHER = "Finding course members by teacher id error ";
    String CREATE_COURSE_MEMBER = "Creating course member error ";
    String FIND_COURSE_MEMBER_BY_STUDENT_AND_COURSE_ID = "Finding course member by student and course id error " ;
    String FIND_COURSE_MEMBERS_WITH_STUDENT_BY_ID = "Finding course members by student id error ";
    String UPDATE_COURSE_MEMBER = "Updating course member error ";
    String CREATE_DAO_FACTORY = "Dao Factory creating error: ";
    String GET_DAO_FACTORY = "Dao Factory creating error: ";
    String USER_LOGIN = "User login error ";
	String USER_TAG_ERROR = "UserInfo tag error ";
}
