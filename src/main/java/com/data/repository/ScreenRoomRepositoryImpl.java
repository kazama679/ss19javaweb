package com.data.repository;

import com.data.entity.ScreenRoom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScreenRoomRepositoryImpl implements ScreenRoomRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ScreenRoom> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from ScreenRoom where status = true", ScreenRoom.class).list();
        }
    }

    @Override
    public void save(ScreenRoom screenRoom) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(screenRoom);
            session.getTransaction().commit();
        }
    }

    @Override
    public ScreenRoom findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ScreenRoom.class, id);
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            ScreenRoom room = session.get(ScreenRoom.class, id);
            if (room != null) {
                room.setStatus(false);
                session.update(room);
            }
            session.getTransaction().commit();
        }
    }
}