package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.Teacher;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Command redirects user on teacher profile
 * 
 * Created by Сергей on 29.07.2016.
 */
public class TeacherProfileCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher teacher = (Teacher)request.getSession().getAttribute(AttributeConstant.USER);
        List studentList = facultativeService.getTeacherStudents(teacher.getId());
        request.getSession().setAttribute(AttributeConstant.STUDENT_LIST, studentList);
        return LinkConstant.TEACHER_PROFILE;
    }
}
