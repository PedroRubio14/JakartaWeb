package org.mons.demo1.controllers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.demo1.dto.CommentDto;
import org.mons.demo1.dto.MovieDto;
import org.mons.demo1.models.Comment;
import org.mons.demo1.models.Movie;
import org.mons.demo1.services.MovieService;
import org.mons.demo1.dao.movie.*;
import org.mons.demo1.services.MovieServiceImp;
import org.mons.demo1.util.jdbcConnector;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(name="movieServlet",value = "/movies")
@WebFilter("/movies")
public class MovieServlet extends HttpServlet implements Filter {

    private MovieServiceImp service;

    @Override
    public void init() throws ServletException {
        service = new MovieServiceImp();

    }




    private void showAllMovies(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<MovieDto> movies  =  service.getMovies();

        req.setAttribute("movies",movies);
        req.getRequestDispatcher("/movies.jsp").forward(req,resp);


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParm  = request.getParameter("id");
        if(idParm == null){
            try {
                showAllMovies(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            String idParam = request.getParameter("id");
            int id = parseInt(idParam);

            List<CommentDto> comments = service.getComments(id);
            MovieDto movie = service.getById(id);

            System.out.println(comments);

            request.setAttribute("movie", movie);
            request.setAttribute("comments", comments);
            request.getRequestDispatcher("/movieDetail.jsp").forward(request, response);
        }

    }

    protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if("POST".equalsIgnoreCase(request.getParameter("__method"))) {
            service.addMovie(new MovieDto(
                    0L,
                    request.getParameter("name"),
                    request.getParameter("description"),
                    parseInt(request.getParameter("year")),
                    new ArrayList<CommentDto>()

            ));

            response.sendRedirect(request.getContextPath() + "/movies");
        }else if ("DELETE".equalsIgnoreCase(request.getParameter("__method"))) {
            String idParam = request.getParameter("id");
            if (idParam != null) {
                int id = parseInt(idParam);
                service.deleteMovieById(id);
            }
            response.sendRedirect(request.getContextPath() + "/movies");

        } else if("PUT".equalsIgnoreCase(request.getParameter("__method"))) {
            long idParam = Long.parseLong(request.getParameter("id"));
            service.updateMovie(new MovieDto(
                    idParam,
                    request.getParameter("name"),
                    request.getParameter("description"),
                    parseInt(request.getParameter("year")),
                    new ArrayList<CommentDto>()

            ));
            response.sendRedirect(request.getContextPath() + "/movies");

        }


    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if("DELETE".equalsIgnoreCase(request.getMethod())) {
            String idParam = request.getParameter("id");
            if (idParam != null) {
                int id = parseInt(idParam);
                service.deleteMovieById(id);
            }

        }
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        if(session == null) {
            response.sendRedirect("login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
