package ua.kpi.tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.kpi.model.entities.User;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

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

    StringWriter sw = new StringWriter();

    public void doTag() {
        JspWriter out = getJspContext().getOut();
        try {
            out.println(user.getName());
            out.println(user.getStatus());
        } catch (IOException e) {
            Logger logger =  LogManager.getLogger(UserInfoTag.class);
            logger.error("UserInfo tag error " + e );
        }
    }
}
