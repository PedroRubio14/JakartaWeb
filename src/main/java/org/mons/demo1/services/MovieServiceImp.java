package org.mons.demo1.services;

import org.mons.demo1.dao.MovieDao;
import org.mons.demo1.dao.MovieDaoOrmImpl;
import org.mons.demo1.dto.MovieDto;
import org.mons.demo1.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceImp implements MovieService {
    private MovieDao dao = new MovieDaoOrmImpl();



    @Override
    public List<MovieDto> getMovies() {
        return movieListToDto(dao.getMovies());
    }

    @Override
    public MovieDto getById(int id) {
        return entityToDto(dao.getById(id));
    }

    @Override
    public boolean addMovie(MovieDto movie) {
        Movie m = dtoToEntity(movie);
        return dao.addMovie(m);
    }

    @Override
    public MovieDto deleteMovieById(int id) {
        return  entityToDto(dao.deleteMovieById(id));
    }


    private Movie dtoToEntity(MovieDto m) {
        return new Movie(m.getId(),m.getName(),m.getDescription(), m.getYear());
    }

    private MovieDto entityToDto(Movie m) {
        return new MovieDto(m.getId(),m.getName(),m.getDescription(), m.getYear());


    }

    private List<Movie> movieDtoListToEntity(List<MovieDto> movies) {
        return movies.stream()
                .map(m -> new Movie(m.getId(),m.getName(),m.getDescription(), m.getYear()))
                .toList();

    }
    private List<MovieDto> movieListToDto(List<Movie> movies) {
        return movies.stream()
                .map(m -> new MovieDto(m.getId(),m.getName(),m.getDescription(), m.getYear()))
                .toList();

    }
}


