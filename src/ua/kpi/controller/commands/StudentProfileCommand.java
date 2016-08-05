package ua.kpi.controller.commands;

import ua.kpi.model.CourseMemberService;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.model.entities.Student;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Command redirects user on student profile
 * 
 * Created by Сергей on 28.07.2016.
 */
public class StudentProfileCommand implements Command {
    CourseMemberService courseMemberService = CourseMemberService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Student student = (Student) request.getSession().getAttribute(AttributeConstant.USER);
        List<CourseMember> courseList = courseMemberService.getStudentCourses(student.getId());
        request.setAttribute(AttributeConstant.COURSE_LIST, courseList);
    	return LinkConstant.STUDENT_PROFILE;
    }
}
