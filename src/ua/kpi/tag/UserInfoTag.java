package ua.kpi.tag;

import org.apache.log4j.Logger;

import ua.kpi.dao.jdbc.constants.ErrorMessage;
import ua.kpi.entities.User;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Custom tag prints info about user
 *
 * Created by Сергей on 01.08.2016.
 */
public class UserInfoTag extends SimpleTagSupport {

	/**
	 * user tag attribute
	 */
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void doTag() {
        JspWriter out = getJspContext().getOut();
        try {
            out.println(user.getName());
            out.println(user.getStatus());
        } catch (IOException e) {
            Logger logger =  Logger.getLogger(UserInfoTag.class);
            logger.error(ErrorMessage.USER_TAG_ERROR + e );
            throw new RuntimeException(e);
        }
    }
}
