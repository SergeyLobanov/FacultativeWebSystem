package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Command gets chosen Student of course for estimation by Teacher
 * 
 * Created by Сергей on 30.07.2016.
 */
public class EstimateCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int index = Integer.parseInt(request.getParameter(AttributeConstant.INDEX));
    	CourseMember courseMember = facultativeService.getCourseMemberById(index);
    	request.setAttribute(AttributeConstant.COURSE_MEMBER, courseMember);
        return LinkConstant.ESTIMATE_STUDENT;
    }
}
