package ua.kpi.controller.commands;

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

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.valueOf(request.getParameter(AttributeConstant.COURSE_ID));
    	//request.getSession().setAttribute("index", Integer.valueOf(request.getParameter("index")));
    	request.getSession().setAttribute(AttributeConstant.COURSE_ID, courseId);
    	request.getSession().setAttribute(AttributeConstant.COURSE, request.getParameter(AttributeConstant.COURSE));
    	return LinkConstant.COURSE_INFO;
    }
}
