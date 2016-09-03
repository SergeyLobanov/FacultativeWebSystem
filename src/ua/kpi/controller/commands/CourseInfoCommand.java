package ua.kpi.controller.commands;

import ua.kpi.services.CourseService;
import ua.kpi.entities.Course;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Command shows information about chosen course
 * 
 * Created by Сергей on 29.07.2016.
 */
public class CourseInfoCommand implements Command {
    public CourseService courseService = CourseService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.valueOf(request.getParameter(AttributeConstant.COURSE_ID));
    	Course course = courseService.getCourseById(courseId);
    	request.setAttribute(AttributeConstant.COURSE, course);
    	return LinkConstant.COURSE_INFO;
    }
}
