package com.data.service;

import com.data.entity.Theater;
import java.util.List;

public interface TheaterService {
    List<Theater> getAll();
    Theater getById(Long id);
    boolean save(Theater theater);
    boolean update(Theater theater);
    boolean delete(Long id);
}