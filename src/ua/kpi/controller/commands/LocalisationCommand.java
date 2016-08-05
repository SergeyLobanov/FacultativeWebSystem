package ua.kpi.controller.commands;

import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class sets localization for web service
 *
 * Created by Сергей on 05.08.2016.
 */
public class LocalisationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter(AttributeConstant.LOCALE);
        request.getSession().setAttribute(AttributeConstant.LANG, language);
        return LinkConstant.INDEX;
    }
}
