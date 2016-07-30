package ua.kpi.controller.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by Сергей on 29.07.2016.
 */
public class CourseInfoCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.valueOf(request.getParameter("courseId"));
    	//request.getSession().setAttribute("index", Integer.valueOf(request.getParameter("index")));
    	request.getSession().setAttribute("courseId", courseId);
    	request.getSession().setAttribute("course", request.getParameter("course"));//todo:just a string
    	return "./WEB-INF/jsp/CourseInfo.jsp";
    }
}
