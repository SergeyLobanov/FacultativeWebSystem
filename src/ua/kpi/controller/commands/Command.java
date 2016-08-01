package ua.kpi.controller.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The command interface
 * 
 * Created by Сергей on 27.07.2016.
 */
public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;

}
