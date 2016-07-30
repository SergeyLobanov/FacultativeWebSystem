package ua.kpi.model;

import ua.kpi.dao.CourseDao;
import ua.kpi.dao.CourseMemberDao;
import ua.kpi.dao.DaoFactory;
import ua.kpi.dao.UserDao;
import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.model.entities.Student;
import ua.kpi.model.entities.User;

import java.util.List;

/**
 * Created by Сергей on 26.07.2016.
 */
public class FacultativeService {

	/**
	 * instance of Facultative service
	 */
    private static FacultativeService instance = new FacultativeService();

    /**
     * 
     * @return instance of Facultative service
     */
    public static FacultativeService getInstance() {
        return instance;
    }

    public boolean isUserExist(String login, String password) {
        DaoFactory factory = DaoFactory.getFactory();
        UserDao userDao = factory.createUserDao();
        return userDao.isUserExist(login, password);
    }

    public User logIn(String login, String password) {
        DaoFactory factory = DaoFactory.getFactory();
        UserDao userDao = factory.createUserDao();
        return userDao.logIn(login, password);
    }

    public List<Course> allCourses() {
        DaoFactory factory = DaoFactory.getFactory();
        CourseDao courseDao = factory.createCourseDao();
        return courseDao.findAll();
    }

    public void joinCourse(Student student, int courseId) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        courseMemberDao.create(student, courseId);
    }

    public List<CourseMember> getTeacherStudents(int id) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return courseMemberDao.findByTeacherID(id);
    }

    public boolean isStudentInCourse(Student student, int courseId) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return (courseMemberDao.find(student, courseId) != null);
    }

    public boolean updateMarkAndComment(CourseMember courseMember) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return courseMemberDao.update(courseMember);
    }

    public List getStudentCourses(int id) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return courseMemberDao.findByStudentID(id);
    }

    //todo: service methods


}
