package org.mons.demo1.interceptor;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.demo1.controllers.MovieServlet;

import java.io.IOException;

@WebFilter("/movies")
public class MovieInterceptor implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
