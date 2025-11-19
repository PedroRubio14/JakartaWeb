package org.mons.demo1.services;

import org.mons.demo1.dao.movie.MovieDao;
import org.mons.demo1.dao.movie.MovieDaoOrmImpl;
import org.mons.demo1.dto.CommentDto;
import org.mons.demo1.dto.MovieDto;
import org.mons.demo1.models.Comment;
import org.mons.demo1.models.Movie;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MovieServiceImp implements MovieService {
    private final MovieDao dao = new MovieDaoOrmImpl();



    @Override
    public List<MovieDto> getMovies() {
        return movieListToDto(dao.getMovies());
    }

    @Override
    public MovieDto getById(int id) {
        Movie movie = dao.getById(id);
        List<CommentDto> comments = getComments(id);
        return new MovieDto(
                movie.getId(),
                movie.getName(),
                movie.getDescription(),
                movie.getYear(),
                comments
        );

        //return movieToDto(dao.getById(id));
    }

    @Override
    public boolean addMovie(MovieDto movie) {
        Movie m = dtoToMovie(movie);
        return dao.addMovie(m);
    }

    @Override
    public MovieDto deleteMovieById(int id) {
        return  movieToDto(dao.deleteMovieById(id));
    }

    @Override
    public MovieDto updateMovie(MovieDto dto) {
        int id = Math.toIntExact(dto.getId());
        Movie movie = dtoToMovie(getById(id));
        movie.setName(dto.getName());
        movie.setDescription(dto.getDescription());
        movie.setYear(dto.getYear());
        return movieToDto(dao.updateMovie(movie));


    }

    @Override
    public List<CommentDto> getComments(int movieId) {
        Movie movie = dao.getById(movieId);
        List<Comment> comments = movie.getComments()
                .stream().sorted((Comparator.comparing(Comment::getCreated_at)).reversed()).toList();
        System.out.println("Comments size: " + comments.size() + " MOVIE_ID: " + movieId);

        if (comments.isEmpty()) {
            System.out.println("No comments " + movieId);
            return null;
        }


        return commentListToDto(movie.getComments());
    }

    private CommentDto commentToDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getMovie().getId(),
                comment.getComment_text(),
                comment.getCreated_at()
        );
    }

    private List<CommentDto> commentListToDto(List<Comment> comments) {

        if(comments == null) {
            return null;
        }
        return comments.stream()
                .map(comment -> new CommentDto(
                        comment.getId(),
                        comment.getMovie().getId(),
                        comment.getComment_text(),
                        comment.getCreated_at()
                )).toList();
    }


    private Movie dtoToMovie(MovieDto m) {
        return new Movie(m.getId(),m.getName(),m.getDescription(), m.getYear());
    }

    private MovieDto movieToDto(Movie m) {
        return new MovieDto(m.getId(),m.getName(),m.getDescription(), m.getYear(), commentListToDto(m.getComments()));


    }

    private List<Movie> movieDtoListToEntity(List<MovieDto> movies) {
        return movies.stream()
                .map(m -> new Movie(m.getId(),m.getName(),m.getDescription(), m.getYear()))
                .toList();

    }
    private List<MovieDto> movieListToDto(List<Movie> movies) {
        return movies.stream()
                .map(m -> new MovieDto(m.getId(),m.getName(),m.getDescription(), m.getYear(), commentListToDto(m.getComments())))
                .toList();

    }
}


