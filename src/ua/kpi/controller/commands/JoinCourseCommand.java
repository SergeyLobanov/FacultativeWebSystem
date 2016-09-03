package ua.kpi.controller.commands;

import ua.kpi.services.CourseService;
import ua.kpi.services.CourseMemberService;
import ua.kpi.entities.Course;
import ua.kpi.entities.Student;
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
    CourseMemberService courseMemberService = CourseMemberService.getInstance();
    CourseService courseService = CourseService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = (Student) request.getSession().getAttribute(AttributeConstant.USER);
        int courseId = Integer.parseInt(request.getParameter(AttributeConstant.COURSE_ID));
    	Course course = courseService.getCourseById(courseId);
    	request.setAttribute(AttributeConstant.COURSE, course);
        if(courseMemberService.isStudentInCourse(student, courseId)) {
            request.setAttribute(AttributeConstant.MESSAGE, MessageConstant.ALREADY_JOINED_IN_COURSE);
        } else {
            courseMemberService.joinCourse(student, courseId);
        }
        return LinkConstant.COURSE_INFO;
    }


}
