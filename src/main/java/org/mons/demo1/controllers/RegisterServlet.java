package org.mons.demo1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mons.demo1.dao.user.UserDaoOrmImpl;
import org.mons.demo1.dto.UserDto;
import org.mons.demo1.models.User;
import org.mons.demo1.services.UserServiceImp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@WebServlet(name="registerServlet",value = "/register")
public class RegisterServlet extends HttpServlet {
    UserServiceImp service = new UserServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto user = service.addUser(
                request.getParameter("username"),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("password")

        );
        if(user != null){
            request.getSession(true).setAttribute("username",user.getUsername());
            response.sendRedirect("movies");
        } else {
            String error = "Usuario ya existe, inicie sesion o registre un usuario con otro nombre";
            request.setAttribute("error",error);
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");

    }




}
