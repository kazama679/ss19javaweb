package com.data.service;

import com.data.entity.Theater;
import com.data.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    private TheaterRepository repo;

    @Override
    public List<Theater> getAll() {
        return repo.findAll();
    }

    @Override
    public Theater getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public boolean save(Theater theater) {
        return repo.save(theater);
    }

    @Override
    public boolean update(Theater theater) {
        return repo.update(theater);
    }

    @Override
    public boolean delete(Long id) {
        return repo.delete(id);
    }
}