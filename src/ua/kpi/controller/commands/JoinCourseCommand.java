package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Сергей on 29.07.2016.
 */
public class JoinCourseCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = (Student) request.getSession().getAttribute("user");
        int courseId = (int) request.getSession().getAttribute("courseId");
        if(facultativeService.isStudentInCourse(student, courseId)) {
            request.setAttribute("message", "You have joined in this course yet");
        } else {
            facultativeService.joinCourse(student, courseId);
        }
        return "./WEB-INF/jsp/CourseInfo.jsp";
    }


}
