package ua.kpi.filter;

import ua.kpi.view.AttributeConstant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter sets character encoding of request and response to UTF-8
 *
 * Created by Сергей on 31.07.2016.
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(AttributeConstant.UTF_8);
        servletResponse.setCharacterEncoding(AttributeConstant.UTF_8);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
