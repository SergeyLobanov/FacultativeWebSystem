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
 * Command sets mark and comment for student of course by teacher 
 * Created by Сергей on 30.07.2016.
 */
public class EditCourseCommand implements Command {
    CourseService courseService = CourseService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int index = Integer.parseInt(request.getParameter(AttributeConstant.COURSE_ID));
    	Course course = courseService.getCourseById(index);
    	request.setAttribute(AttributeConstant.COURSE, course);
        return LinkConstant.EDIT_COURSE_INFO;
    }
}
