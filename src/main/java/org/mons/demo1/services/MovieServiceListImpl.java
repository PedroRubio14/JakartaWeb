//package org.mons.demo1.services;
//
//
//
//import org.mons.demo1.models.Movie;
//
//import java.util.Collections;
//import java.util.List;
//
//public class MovieServiceListImpl implements MovieService {
//
//    private static List<Movie>movies;
//
//     static {
//         movies = List.of(
//                 new Movie(1, "Inception", "A thief enters dreams to steal secrets.", 2010),
//                 new Movie(2, "The Matrix", "A hacker discovers reality is a simulation.", 1999),
//                 new Movie(3, "Interstellar", "Explorers travel through a wormhole in space.", 2014),
//                 new Movie(4, "The Dark Knight", "Batman faces the Joker in Gotham City.", 2008),
//                 new Movie(5, "Parasite", "A poor family infiltrates a wealthy household.", 2019),
//                 new Movie(6, "Pulp Fiction", "Interwoven crime stories in Los Angeles.", 1994),
//                 new Movie(7, "The Shawshank Redemption", "A man imprisoned for a crime he didn't commit.", 1994),
//                 new Movie(8, "Fight Club", "An underground fight club forms with dark motives.", 1999),
//                 new Movie(9, "Forrest Gump", "The life journey of a kind-hearted man.", 1994),
//                 new Movie(10, "The Lord of the Rings: The Fellowship of the Ring", "A quest to destroy a powerful ring.", 2001),
//                 new Movie(11, "Gladiator", "A betrayed general seeks revenge in Rome.", 2000),
//                 new Movie(12, "Titanic", "A love story aboard a doomed ship.", 1997),
//                 new Movie(13, "The Godfather", "The story of a powerful mafia family.", 1972),
//                 new Movie(14, "Avatar", "A human explores an alien world on Pandora.", 2009),
//                 new Movie(15, "The Avengers", "Earth’s mightiest heroes team up to save the world.", 2012)
//         );
//     }
//
//    public List<Movie> getMovies() {
//        return Collections.unmodifiableList(movies);
//    }
//
//
//    public Movie getById(int id) {
//        return movies.stream().filter(movie -> movie.getId() == id).findFirst().orElse(null);
//    }
//
//    public  boolean addMovie(Movie movie) {
//        return movies.add(movie);
//    }
//
//    public  Movie deleteMovieById(int id) {
//        Movie movie = getById(id);
//        return movies.remove(movie) ? movie : null;
//    }
//
//}
