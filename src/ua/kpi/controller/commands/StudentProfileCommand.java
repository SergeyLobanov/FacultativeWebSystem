package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.model.entities.Student;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Command redirects user on student profile
 * 
 * Created by Сергей on 28.07.2016.
 */
public class StudentProfileCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Logger logger =  LogManager.getLogger(StudentProfileCommand.class);
        logger.error("testing ERROR level");
        logger.trace("exiting application");
        Student student = (Student) request.getSession().getAttribute(AttributeConstant.USER);
        List<CourseMember> courseList = facultativeService.getStudentCourses(student.getId());
        request.setAttribute(AttributeConstant.COURSE_LIST, courseList);
    	return LinkConstant.STUDENT_PROFILE;
    }
}
