package com.data.service;

import com.data.entity.Movie;
import com.data.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void update(Movie movie) {
        movieRepository.update(movie);
    }

    @Override
    public void deleteOrDisable(Long id) {
        if (movieRepository.hasSchedules(id)) {
            Movie m = movieRepository.findById(id);
            if (m != null) {
                m.setStatus(false);
                movieRepository.update(m);
            }
        } else {
            movieRepository.delete(id);
        }
    }
}