package com.data.repository;

import com.data.entity.Movie;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Movie> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Movie", Movie.class)
                .list();
    }

    @Override
    public Movie findById(Long id) {
        return sessionFactory.getCurrentSession().get(Movie.class, id);
    }

    @Override
    public void save(Movie movie) {
        sessionFactory.getCurrentSession().save(movie);
    }

    @Override
    public void update(Movie movie) {
        sessionFactory.getCurrentSession().update(movie);
    }

    @Override
    public void delete(Long id) {
        Movie movie = findById(id);
        if (movie != null) {
            sessionFactory.getCurrentSession().delete(movie);
        }
    }

    @Override
    public boolean hasSchedules(Long movieId) {
        return false;
    }
}