package ua.kpi.controller.commands;

import ua.kpi.services.CourseMemberService;
import ua.kpi.entities.CourseMember;
import ua.kpi.entities.Teacher;
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
    CourseMemberService courseMemberService = CourseMemberService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Teacher teacher = (Teacher)request.getSession().getAttribute(AttributeConstant.USER);
        List<CourseMember> studentList = courseMemberService.getTeacherStudents(teacher.getId());
        request.setAttribute(AttributeConstant.STUDENT_LIST, studentList);
        return LinkConstant.TEACHER_PROFILE;
    }
}
