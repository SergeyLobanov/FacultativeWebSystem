package ua.kpi.controller.commands;

import ua.kpi.model.CourseMemberService;
import ua.kpi.model.CourseService;
import ua.kpi.model.entities.Course;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;
import ua.kpi.view.MessageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Command sets mark and comment for student of course by teacher 
 * Created by Сергей on 30.07.2016.
 */
public class RegistrationCommand implements Command {
    CourseService courseService = CourseService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	return LinkConstant.REGISTRATION;
    }
}
