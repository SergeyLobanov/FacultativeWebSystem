package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.Course;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Command shows information about chosen course
 * 
 * Created by Сергей on 29.07.2016.
 */
public class CourseInfoCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger =  LogManager.getLogger(CourseInfoCommand.class);
        logger.error("testing ERROR level");
        logger.trace("exiting application");
    	int courseId = Integer.valueOf(request.getParameter(AttributeConstant.COURSE_ID));
    	Course course = facultativeService.getCourseById(courseId);
    	//request.getSession().setAttribute("index", Integer.valueOf(request.getParameter("index")));
    	//request.setAttribute(AttributeConstant.COURSE_ID, courseId);
    	request.setAttribute(AttributeConstant.COURSE, course);
    	return LinkConstant.COURSE_INFO;
    }
}
