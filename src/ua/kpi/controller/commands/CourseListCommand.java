package ua.kpi.controller.commands;

import ua.kpi.model.CourseService;
import ua.kpi.model.entities.Course;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Command get list of all facultative courses 
 * 
 * Created by Сергей on 28.07.2016.
 */
public class CourseListCommand implements Command {
    CourseService courseService = CourseService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courseList = courseService.allCourses();
        request.setAttribute(AttributeConstant.COURSE_LIST, courseList);
        return LinkConstant.ALL_COURSES;
    }
}
