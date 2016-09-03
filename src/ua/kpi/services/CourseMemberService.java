package ua.kpi.services;

import ua.kpi.dao.CourseMemberDao;
import ua.kpi.dao.DaoFactory;
import ua.kpi.entities.CourseMember;
import ua.kpi.entities.Student;

import java.util.List;

/**
 * Main class for service the Facultative Web System
 *
 * Created by Сергей on 26.07.2016.
 */
public class CourseMemberService {

	/**
	 * instance of Facultative service
	 */
    private static CourseMemberService instance = new CourseMemberService();

    /**
     * private constructor for singleton
     */
    private CourseMemberService(){}

    /**
     * 
     * @return instance of Facultative service
     */
    public static CourseMemberService getInstance() {
        return instance;
    }

    /**
     * add student to course with course id
     * @param student student that added
     * @param courseId id of course where student added
     */
    public void joinCourse(Student student, int courseId) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        courseMemberDao.create(student, courseId);
    }

    /**
     * finds course members of teacher course by teacher id
     * @param id of teacher to search
     * @return list of course members
     */
    public List<CourseMember> getTeacherStudents(int id) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return courseMemberDao.findByTeacherID(id);
    }

    /**
     * verifies is student in course
     * @param student that verified
     * @param courseId id of course that verified
     * @return result of verification
     */
    public boolean isStudentInCourse(Student student, int courseId) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return (courseMemberDao.find(student, courseId) != null);
    }

    /**
     * updates mark and comment of CourseMember
     * @param courseMember course member that updates
     * @return is course member updated
     */
    public boolean updateMarkAndComment(CourseMember courseMember) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return courseMemberDao.update(courseMember);
    }

    /**
     * gets list of course members where student takes part by id
     * @param id of student
     * @return list of course members
     */
    public List<CourseMember> getStudentCourses(int id) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return courseMemberDao.findByStudentID(id);
    }

    /**
     * get CourseMember by id
     * @param courseMemberId id of course member
     * @return course member
     */
    public CourseMember getCourseMemberById(int courseMemberId) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseMemberDao courseMemberDao = factory.createCourseMemberDao();
        return courseMemberDao.find(courseMemberId);
    }


}
