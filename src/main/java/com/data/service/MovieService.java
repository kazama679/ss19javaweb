package com.data.service;

import com.data.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
    Movie getById(Long id);
    void save(Movie movie);
    void update(Movie movie);
    void deleteOrDisable(Long id);
}
