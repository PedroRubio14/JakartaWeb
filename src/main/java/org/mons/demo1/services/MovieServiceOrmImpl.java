//package org.mons.demo1.services;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import org.mons.demo1.models.Movie;
//import org.mons.demo1.util.ConnectionManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MovieServiceOrmImpl implements MovieService{
//
//
//    private EntityManager em;
//
//    public MovieServiceOrmImpl() {
//        this.em = ConnectionManager.getEntityManager();
//    }
//
//
//    @Override
//    public List<Movie> getMovies() {
//        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
//    }
//
//    @Override
//    public Movie getById(int id) {
//        return em.find(Movie.class, id);
//
//    }
//
//    @Override
//    public boolean addMovie(Movie movie) {
//        em.getTransaction().begin();
//        em.persist(movie);
//        em.getTransaction().commit();
//        return true;
//    }
//
//    @Override
//    public Movie deleteMovieById(int id) {
//        Movie movie = getById(id);
//        em.getTransaction().begin();
//        em.remove(movie);
//        em.getTransaction().commit();
//        return movie;
//    }
//}
