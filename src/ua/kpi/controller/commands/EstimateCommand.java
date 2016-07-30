package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.CourseMember;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Сергей on 30.07.2016.
 */
public class EstimateCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int index = Integer.parseInt(request.getParameter("index"));
    	CourseMember courseMember = (CourseMember)((List)request.getSession()
    									.getAttribute("studentList")).get(index);
    	request.getSession().setAttribute("courseMember", courseMember);
        return "./WEB-INF/jsp/EstimateStudent.jsp";
    }
}
