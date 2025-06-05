package com.data.service;

import com.data.entity.ScreenRoom;
import com.data.entity.Seat;
import com.data.repository.ScreenRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenRoomRepositoryImpl implements ScreenRoomService {
    @Autowired
    private ScreenRoomRepository screenRoomRepository;

    @Override
    public List<ScreenRoom> findAll() {
        return screenRoomRepository.findAll();
    }

    @Override
    public void save(ScreenRoom screenRoom) {
        if (screenRoom.getId() == null) {
            List<Seat> seats = new ArrayList<>();
            for (int i = 1; i <= screenRoom.getCapacity(); i++) {
                Seat seat = new Seat();
                seat.setSeatName("A" + i);
                seat.setStatus(true);
                seat.setScreenRoom(screenRoom);
                seats.add(seat);
            }
            screenRoom.setSeats(seats);
        }
        screenRoomRepository.save(screenRoom);
    }

    @Override
    public ScreenRoom findById(Long id) {
        return screenRoomRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        screenRoomRepository.delete(id);
    }
}