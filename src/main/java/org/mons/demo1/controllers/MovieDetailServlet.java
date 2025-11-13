package org.mons.demo1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mons.demo1.models.Movie;
import org.mons.demo1.services.MovieService;
import org.mons.demo1.services.MovieServiceOrmImpl;

import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet(name="movieDetailServlet", value="/movie")
public class MovieDetailServlet extends HttpServlet {

    private MovieService service;

    @Override
    public void init() {
        service = new MovieServiceOrmImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/movies");
            return;
        }

        int id = parseInt(idParam);
        Movie movie = service.getById(id);

        req.setAttribute("movie", movie);
        req.getRequestDispatcher("/movieDetail.jsp").forward(req, resp);
    }
}

