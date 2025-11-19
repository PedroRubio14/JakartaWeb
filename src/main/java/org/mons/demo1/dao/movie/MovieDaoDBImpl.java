package org.mons.demo1.dao.movie;

import org.mons.demo1.models.Movie;
import org.mons.demo1.util.jdbcConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoDBImpl implements MovieDao {
    @Override
    public List<Movie> getMovies() {

        List<Movie> movies = new ArrayList<>();

        try{
            Connection connection = jdbcConnector.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * from movies;");
            ResultSet result = pst.executeQuery();

            while(result.next()) {
                long movieId = result.getLong("id");
                String movieTitle = result.getString("title");
                String movieDesc = result.getString("description");
                int movieYear= result.getInt("year");


                Movie movie = new Movie(movieId,movieTitle,movieDesc,movieYear);
                movies.add(movie);


            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movies;


    }

    @Override
    public Movie getById(int id) {
        try{
            Connection connection = jdbcConnector.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * from movies where id = ?;");
            pst.setInt(1,id);
            ResultSet result = pst.executeQuery();

            if(result.next()) {
                Movie m = new Movie(
                        result.getLong("id"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getInt("year")
                );
                connection.close();
                return m;

            }else {
                return null;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addMovie(Movie movie) {

        try{
            Connection connection = jdbcConnector.getConnection();
            PreparedStatement pst = connection.prepareStatement("INSERT INTO movies (title,description,year) VALUES (?,?,?);");
            pst.setString(1,movie.getName());
            pst.setString(2,movie.getDescription());
            pst.setInt(3,movie.getYear());
            int result = pst.executeUpdate();
            connection.close();

            return result > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Movie deleteMovieById(int id) {
        try{
            Movie movie = getById(id);
            Connection connection = jdbcConnector.getConnection();
            PreparedStatement pst = connection.prepareStatement("DELETE from movies where id = ?;");
            pst.setInt(1,id);
            int result = pst.executeUpdate();
            connection.close();

            if(result>0) {
                return movie;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Movie updateMovie(Movie movie) {
        int id = Math.toIntExact(movie.getId());
        try{
            Connection connection = jdbcConnector.getConnection();
            PreparedStatement pst = connection.prepareStatement("UPDATE movies SET title = ?, description = ?, year = ? WHERE id = ?;");
            pst.setString(1,movie.getName());
            pst.setString(2,movie.getDescription());
            pst.setInt(3,movie.getYear());
            pst.setInt(4,id);
            pst.executeUpdate();
            connection.close();
            return movie;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public List<Comment> getComments(int movieId) {
//
//        try{
//            Connection connection = jdbcConnector.getConnection();
//            PreparedStatement pst = connection.prepareStatement("SELECT * from comments where movie_id = ?;");
//            pst.setInt(1,movieId);
//            ResultSet result = pst.executeQuery();
//
//            List<Comment> comments = new ArrayList<>();
//            while(result.next()){
//                long id = result.getLong("id");
//                long movie_id = result.getLong("movie_id");
//                String comment_text = result.getString("comment_text");
//                Timestamp created_at = result.getTimestamp("created_at");
//
//                Movie movie = getById((int) movie_id);
//
//
//                Comment comment = new Comment(id, movie,comment_text,created_at);
//                comments.add(comment);
//
//            }
//            connection.close();
//
//            return comments;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
}
