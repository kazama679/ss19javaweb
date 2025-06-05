package com.data.service;

import com.data.entity.ScreenRoom;

import java.util.List;

public interface ScreenRoomService {
    List<ScreenRoom> findAll();
    void save(ScreenRoom screenRoom);
    ScreenRoom findById(Long id);
    void delete(Long id);
}
