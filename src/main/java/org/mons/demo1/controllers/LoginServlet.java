package org.mons.demo1.controllers;


import com.google.common.hash.Hashing;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mons.demo1.dto.UserDto;
import org.mons.demo1.models.User;
import org.mons.demo1.services.UserServiceImp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="loginServlet",value = "/login")
public class LoginServlet extends HttpServlet {

    UserServiceImp service = new UserServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto user = service.getUser(request.getParameter("username"));

        String password = Hashing.sha256()
                .hashString(request.getParameter("password"), StandardCharsets.UTF_8)
                .toString();

        if (!service.validateUser(user, password) || user == null) {
            response.sendRedirect("login.jsp");


        } else {
            request.getSession(true).setAttribute("username", user.getUsername());
            response.sendRedirect("movies");

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");

    }



}
