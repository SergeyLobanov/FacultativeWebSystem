package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
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
        int courseId = (int) request.getSession().getAttribute(AttributeConstant.COURSE_ID);
        if(facultativeService.isStudentInCourse(student, courseId)) {
            request.setAttribute(AttributeConstant.MESSAGE, MessageConstant.ALREADY_JOINED_IN_COURSE);
        } else {
            facultativeService.joinCourse(student, courseId);
        }
        return LinkConstant.COURSE_INFO;
    }


}
