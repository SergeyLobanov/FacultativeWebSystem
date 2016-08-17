package ua.kpi.model;

import ua.kpi.dao.CourseDao;
import ua.kpi.dao.DaoFactory;
import ua.kpi.model.entities.Course;

import java.util.List;

/**
 * Created by Сергей on 02.08.2016.
 */
public class CourseService {
    /**
     * instance of Course service
     */
    private static CourseService instance = new CourseService();

    /**
     *
     * @return instance of Course service
     */
    public static CourseService getInstance() {
        return instance;
    }

    /**
     * finds all courses
     * @return course list
     */
    public List<Course> allCourses() {
        DaoFactory factory = DaoFactory.getFactory();
        CourseDao courseDao = factory.createCourseDao();
        return courseDao.findAll();
    }

    /**
     * get course by id
     * @param courseId id of course
     * @return course
     */
    public Course getCourseById(int courseId) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseDao courseDao = factory.createCourseDao();
        return courseDao.find(courseId);
    }

	public void createCourse(Course course) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseDao courseDao = factory.createCourseDao();
        courseDao.create(course);		
	}
	
	public void updateCourse(Course course) {
        DaoFactory factory = DaoFactory.getFactory();
        CourseDao courseDao = factory.createCourseDao();
        courseDao.update(course);		
	}
}
