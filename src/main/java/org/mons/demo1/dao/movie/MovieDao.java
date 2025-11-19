package org.mons.demo1.dao.movie;

import org.mons.demo1.models.Movie;

import java.util.List;

public interface MovieDao {
    public List<Movie> getMovies();
    public Movie getById(int id);
    public boolean addMovie(Movie movie);
    public Movie deleteMovieById(int id);
    public Movie  updateMovie(Movie movie);
    //public List<Comment> getComments(int movieId);
}
