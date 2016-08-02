package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.Student;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;
import ua.kpi.view.MessageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Command adds Student to chosen course 
 * 
 * Created by Сергей on 29.07.2016.
 */
public class JoinCourseCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = (Student) request.getSession().getAttribute(AttributeConstant.USER);
        int courseId = Integer.parseInt(request.getParameter(AttributeConstant.COURSE_ID));
    	Course course = facultativeService.getCourseById(courseId);
    	request.setAttribute(AttributeConstant.COURSE, course);
        if(facultativeService.isStudentInCourse(student, courseId)) {
            request.setAttribute(AttributeConstant.MESSAGE, MessageConstant.ALREADY_JOINED_IN_COURSE);
        } else {
            facultativeService.joinCourse(student, courseId);
        }
        return LinkConstant.COURSE_INFO;
    }


}
