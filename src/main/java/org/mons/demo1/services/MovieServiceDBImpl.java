//package org.mons.demo1.services;
//
//import org.mons.demo1.models.Movie;
//import org.mons.demo1.util.jdbcConnector;
//
//import java.sql.Connection;
//import java.io.IOException;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static java.lang.Integer.parseInt;
//
//public class MovieServiceDBImpl implements MovieService {
//
//    @Override
//    public List<Movie> getMovies() {
//
//        List<Movie> movies = new ArrayList<>();
//
//        try{
//            Connection connection = jdbcConnector.getConnection();
//            PreparedStatement pst = connection.prepareStatement("SELECT * from movies;");
//            ResultSet result = pst.executeQuery();
//
//            while(result.next()) {
//                long movieId = result.getLong("id");
//                String movieTitle = result.getString("title");
//                String movieDesc = result.getString("description");
//                int movieYear= result.getInt("year");
//
//
//                Movie movie = new Movie(movieId,movieTitle,movieDesc,movieYear);
//                movies.add(movie);
//                connection.close();
//
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return movies;
//
//
//    }
//
//    @Override
//    public Movie getById(int id) {
//        try{
//            Connection connection = jdbcConnector.getConnection();
//            PreparedStatement pst = connection.prepareStatement("SELECT * from movies where id = ?;");
//            pst.setInt(1,id);
//            ResultSet result = pst.executeQuery();
//            connection.close();
//
//            if(result.next()) {
//                return new Movie(
//                        result.getLong("id"),
//                        result.getString("title"),
//                        result.getString("description"),
//                        result.getInt("year")
//                );
//            }else {
//                return null;
//            }
//
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public boolean addMovie(Movie movie) {
//
//        try{
//            Connection connection = jdbcConnector.getConnection();
//            PreparedStatement pst = connection.prepareStatement("INSERT INTO MOVIES(title,description,year) VALUES (?,?,?);)");
//            pst.setString(1,movie.getName());
//            pst.setString(2,movie.getDescription());
//            pst.setInt(3,movie.getYear());
//            int result = pst.executeUpdate();
//            connection.close();
//
//            return result > 0;
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @Override
//    public Movie deleteMovieById(int id) {
//        try{
//            Movie movie = getById(id);
//            Connection connection = jdbcConnector.getConnection();
//            PreparedStatement pst = connection.prepareStatement("DELETE from movies where id = ?;");
//            pst.setInt(1,id);
//            int result = pst.executeUpdate();
//            connection.close();
//
//            if(result>0) {
//                return movie;
//            } else {
//                return null;
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
