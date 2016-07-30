package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.Student;
import ua.kpi.model.entities.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Сергей on 28.07.2016.
 */
public class StudentProfileCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = (Student) request.getSession().getAttribute("user");
        List courseList = facultativeService.getStudentCourses(student.getId());
        request.getSession().setAttribute("courseList", courseList);
    	return "./WEB-INF/jsp/StudentProfile.jsp";
    }
}
