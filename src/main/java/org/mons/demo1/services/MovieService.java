package org.mons.demo1.services;

import org.mons.demo1.dto.CommentDto;
import org.mons.demo1.dto.MovieDto;
import org.mons.demo1.models.Comment;

import java.util.List;

public interface MovieService  {

    public List<MovieDto> getMovies();
    public MovieDto getById(int id);
    public boolean addMovie(MovieDto movie);
    public MovieDto deleteMovieById(int id);
    public MovieDto  updateMovie(MovieDto movie);
    public List<CommentDto>  getComments(int movieId);
}
