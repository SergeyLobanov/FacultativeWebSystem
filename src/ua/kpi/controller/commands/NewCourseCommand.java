package ua.kpi.controller.commands;

import ua.kpi.view.LinkConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Command adds Student to chosen course 
 * 
 * Created by Сергей on 29.07.2016.
 */
public class NewCourseCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        return LinkConstant.ADD_COURSE;
    }


}
