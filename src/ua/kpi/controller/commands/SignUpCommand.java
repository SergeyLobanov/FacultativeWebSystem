package ua.kpi.controller.commands;

import ua.kpi.dao.jdbc.constants.ErrorMessage;
import ua.kpi.services.UserService;
import ua.kpi.entities.Student;
import ua.kpi.entities.Teacher;
import ua.kpi.entities.User;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;
import ua.kpi.view.MessageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Command check is user with such login and password exist
 * and starts session with him.
 * 
 * Created by Сергей on 28.07.2016.
 */
public class SignUpCommand implements Command {
    UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name = request.getParameter(AttributeConstant.NAME);
    	String login = request.getParameter(AttributeConstant.LOGIN);
        String password = request.getParameter(AttributeConstant.PASSWORD);
        String confirmPassword = request.getParameter(AttributeConstant.CONFIRM_PASSWORD);
        String status = request.getParameter(AttributeConstant.STATUS);

        if(userService.isLoginUnavailable(login)) {
            request.setAttribute(AttributeConstant.MESSAGE, MessageConstant.UNAVAILABLE_LOGIN);
            return LinkConstant.REGISTRATION;        	
        }
        
        if(!password.equals(confirmPassword)) {
            request.setAttribute(AttributeConstant.MESSAGE, MessageConstant.NOT_SAME_PASSWORD);
            return LinkConstant.REGISTRATION;               	
        }

        User.Status userStatus = User.Status.valueOf(status);
        
        User user = null;
        switch(userStatus) {
        	case STUDENT:
        		user = new Student(0, name, login, password);
        		break;
        	case TEACHER:
        		user = new Teacher(0, name, login, password);
        		break;
        	default:
                Logger logger =  Logger.getLogger(SignUpCommand.class);
                logger.error(ErrorMessage.WRONG_STATUS);
                throw new RuntimeException();
        }
        
        userService.createUser(user);
        request.setAttribute(AttributeConstant.MESSAGE, MessageConstant.USER_CREATED);
        
        return LinkConstant.INDEX;
    }
}
