package com.data.repository;

import com.data.entity.ScreenRoom;

import java.util.List;

public interface ScreenRoomRepository {
    List<ScreenRoom> findAll();
    void save(ScreenRoom screenRoom);
    ScreenRoom findById(Long id);
    void delete(Long id);
}
