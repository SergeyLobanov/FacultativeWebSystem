package ua.kpi.controller.commands;

import ua.kpi.dao.jdbc.constants.ErrorMessage;
import ua.kpi.services.CourseService;
import ua.kpi.entities.Course;
import ua.kpi.entities.Teacher;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Command sets mark and comment for student of course by teacher 
 * Created by Сергей on 30.07.2016.
 */
public class SetCourseInfoCommand implements Command {
    CourseService courseService = CourseService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Teacher teacher = (Teacher) request.getSession().getAttribute(AttributeConstant.USER);
    	int courseId = Integer.parseInt(request.getParameter(AttributeConstant.COURSE_ID));
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
            Logger logger =  Logger.getLogger(SetCourseInfoCommand.class);
            logger.error(ErrorMessage.DATE_PARSING + e );
            throw new RuntimeException(e);
		}
        java.sql.Date startCourse = new java.sql.Date(startDate.getTime());
        java.sql.Date endCourse = new java.sql.Date(endDate.getTime());
		Course course = new Course(courseId, courseName, teacher, startCourse, endCourse);
    	request.setAttribute(AttributeConstant.COURSE, course);
    	courseService.updateCourse(course);
        return LinkConstant.EDIT_COURSE_INFO;
    }
}
