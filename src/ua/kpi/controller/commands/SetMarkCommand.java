package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.CourseMember;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Сергей on 30.07.2016.
 */
public class SetMarkCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int mark = Integer.parseInt(request.getParameter("mark"));
    	String comment = request.getParameter("comment");
    	CourseMember courseMember = (CourseMember)request.getSession().getAttribute("courseMember");
    	courseMember.setMark(mark);
    	courseMember.setComment(comment);
    	if (facultativeService.updateMarkAndComment(courseMember)) {
            request.setAttribute("message", "Mark and comment are updated succcesfully!");    		
    	} else {
            request.setAttribute("message", "Info is not updated!");    		
    	}
        return "./WEB-INF/jsp/EstimateStudent.jsp";
    }
}
