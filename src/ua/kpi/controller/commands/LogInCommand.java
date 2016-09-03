package ua.kpi.controller.commands;

import ua.kpi.services.UserService;
import ua.kpi.entities.User;
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

    UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AttributeConstant.LOGIN);
        String password = request.getParameter(AttributeConstant.PASSWORD);

        User user = userService.logIn(login, password);
        if (user == null) {
            request.setAttribute(AttributeConstant.MESSAGE, MessageConstant.WRONG_LOGIN_OR_PASSWORD);
            return LinkConstant.INDEX;
        }
        request.getSession().setAttribute(AttributeConstant.USER, user);
        //request.getSession().setAttribute(AttributeConstant.STATUS, user.getStatus().toString());
        return LinkConstant.MAIN;
    }
}
