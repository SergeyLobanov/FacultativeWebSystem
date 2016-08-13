package ua.kpi.filter;

import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;
import ua.kpi.view.MessageConstant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter verifies user authentication in the system
 *
 * Created by Сергей on 31.07.2016.
 */
@WebFilter("/WEB_INF/jsp/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest.getAttribute(AttributeConstant.USER) == null) {
        	servletRequest.setAttribute(AttributeConstant.MESSAGE, MessageConstant.AUTHORISE_FOR_WORK);
			RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(LinkConstant.INDEX);
			dispatcher.forward(servletRequest, servletResponse);            
        }
        filterChain.doFilter(servletRequest, servletResponse);
        
    }

    @Override
    public void destroy() {

    }
}
