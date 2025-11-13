package org.mons.demo1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mons.demo1.services.MovieService;
import org.mons.demo1.services.MovieServiceOrmImpl;

import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet(name="movieDeleteServlet", value="/movie/delete")
public class MovieDeleteServlet extends HttpServlet {

    private MovieService service;

    @Override
    public void init() {
        service = new MovieServiceOrmImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null) {
            int id = parseInt(idParam);
            service.deleteMovieById(id);
        }

        resp.sendRedirect(req.getContextPath() + "/movies");
    }
}

