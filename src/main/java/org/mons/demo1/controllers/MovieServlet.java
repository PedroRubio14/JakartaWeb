package org.mons.demo1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mons.demo1.models.Movie;
import org.mons.demo1.services.MovieService;
import org.mons.demo1.services.MovieServiceOrmImpl;
import org.mons.demo1.util.jdbcConnector;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(name="movieServlet",value = "/movies")
public class MovieServlet extends HttpServlet {

    private MovieService service;

    @Override
    public void init() throws ServletException {
        service = new MovieServiceOrmImpl();

    }




    private void showAllMovies(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Movie> movies = new ArrayList<>();

        Connection conn = jdbcConnector.getConnection();

        PreparedStatement pst = conn.prepareStatement("SELECT * from movies;");
        ResultSet result = pst.executeQuery();

        while(result.next()){
            long movieId = result.getLong("id");
            String movieTitle = result.getString("title");
            String movieDesc = result.getString("description");
            int movieYear= result.getInt("year");


            Movie movie = new Movie(movieId,movieTitle,movieDesc,movieYear);
            movies.add(movie);
        }
        conn.close();


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
            Movie movie = service.getById(id);

            request.setAttribute("movie", movie);
            request.getRequestDispatcher("/movieDetail.jsp").forward(request, response);
        }

    }

    protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if("POST".equalsIgnoreCase(request.getParameter("__method"))) {
            service.addMovie(new Movie(
                    0L,
                    request.getParameter("name"),
                    request.getParameter("description"),
                    parseInt(request.getParameter("year"))
            ));

            response.sendRedirect(request.getContextPath() + "/movies");
        }else if ("DELETE".equalsIgnoreCase(request.getParameter("__method"))) {
            String idParam = request.getParameter("id");
            if (idParam != null) {
                int id = parseInt(idParam);
                service.deleteMovieById(id);
            }
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



}
