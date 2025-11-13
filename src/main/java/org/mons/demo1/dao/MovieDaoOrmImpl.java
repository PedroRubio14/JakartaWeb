package org.mons.demo1.dao;

import jakarta.persistence.EntityManager;
import org.mons.demo1.models.Movie;
import org.mons.demo1.util.ConnectionManager;

import java.util.List;

public class MovieDaoOrmImpl implements MovieDao {

    private EntityManager em;

    public MovieDaoOrmImpl() {
        this.em = ConnectionManager.getEntityManager();
    }


    @Override
    public List<Movie> getMovies() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    @Override
    public Movie getById(int id) {
        return em.find(Movie.class, id);

    }

    @Override
    public boolean addMovie(Movie movie) {
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public Movie deleteMovieById(int id) {
        Movie movie = getById(id);
        em.getTransaction().begin();
        em.remove(movie);
        em.getTransaction().commit();
        return movie;
    }
}
