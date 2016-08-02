package ua.kpi.controller.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.User;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;
import ua.kpi.view.MessageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Command check is user with such login and password exist
 * and starts session with him.
 * 
 * Created by Сергей on 28.07.2016.
 */
public class LogInCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AttributeConstant.LOGIN);
        String password = request.getParameter(AttributeConstant.PASSWORD);
        //todo:logger
        Logger logger =  LogManager.getLogger(LogInCommand.class);
        logger.error("testing ERROR level");
        logger.trace("exiting application");
        
        if (!facultativeService.isUserExist(login, password)) {
            request.setAttribute(AttributeConstant.MESSAGE, MessageConstant.WRONG_LOGIN_OR_PASSWORD);
            return LinkConstant.INDEX;
        }
        User user = facultativeService.logIn(login, password);
        request.getSession().setAttribute(AttributeConstant.USER, user);
        request.getSession().setAttribute(AttributeConstant.STATUS, user.getStatus().toString());
        return LinkConstant.MAIN;
    }
}
