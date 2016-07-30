package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Сергей on 28.07.2016.
 */
public class CourseListCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List courseList = facultativeService.allCourses();
        request.setAttribute("courseList", courseList);
        return "./WEB-INF/jsp/AllCourses.jsp";
    }
}
