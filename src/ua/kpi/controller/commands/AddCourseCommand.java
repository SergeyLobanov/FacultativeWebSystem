package ua.kpi.controller.commands;

import ua.kpi.model.CourseService;
import ua.kpi.dao.jdbc.JdbcCourseDao;
import ua.kpi.dao.jdbc.constants.ErrorMessage;
import ua.kpi.model.CourseMemberService;
import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.Student;
import ua.kpi.model.entities.Teacher;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;
import ua.kpi.view.MessageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Command adds Student to chosen course 
 * 
 * Created by Сергей on 29.07.2016.
 */
public class AddCourseCommand implements Command {
    CourseService courseService = CourseService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Teacher teacher = (Teacher) request.getSession().getAttribute(AttributeConstant.USER);        
    	String courseName = request.getParameter("course");
		String start = request.getParameter("start");;
		String end = request.getParameter("end");;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = sdf.parse(start);
			endDate = sdf.parse(end);
		} catch (ParseException e) {
            Logger logger =  Logger.getLogger(AddCourseCommand.class);
            logger.error(ErrorMessage.DATE_PARSING + e );
            throw new RuntimeException(e);
		}
        java.sql.Date startCourse = new java.sql.Date(startDate.getTime());
        java.sql.Date endCourse = new java.sql.Date(endDate.getTime());
		Course course = new Course(1, courseName, teacher, startCourse, endCourse);
    	courseService.createCourse(course);
    	return LinkConstant.ADD_COURSE;
    }


}
