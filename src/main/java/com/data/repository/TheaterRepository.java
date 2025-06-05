package com.data.repository;

import com.data.entity.Theater;

import java.util.List;

public interface TheaterRepository {
    List<Theater> findAll();
    Theater findById(Long id);
    boolean save(Theater theater);
    boolean update(Theater theater);
    boolean delete(Long id);
}
