package com.data.repository;

import com.data.entity.Theater;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TheaterRepositoryImpl implements TheaterRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Theater> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Theater", Theater.class).list();
        }
    }

    @Override
    public Theater findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Theater.class, id);
        }
    }

    @Override
    public boolean save(Theater theater) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(theater);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Theater theater) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.update(theater);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            Theater t = session.get(Theater.class, id);
            if (t != null) {
                // giả định có hàm kiểm tra lịch chiếu: hasSchedule(t.getId())
                boolean hasSchedule = false;
                if (hasSchedule) {
                    t.setStatus(false);
                    session.update(t);
                } else {
                    session.delete(t);
                }
                tx.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}