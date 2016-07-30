package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Сергей on 28.07.2016.
 */
public class LogInCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (!facultativeService.isUserExist(login, password)) {
            request.setAttribute("message", "Wrong login or password");
            return "index.jsp";
        }
        //request.removeAttribute("message");
        //todo: remove message from jsp
        User user = facultativeService.logIn(login, password);
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("status", user.getStatus().toString());
        return "./WEB-INF/jsp/main.jsp";
    }
}
