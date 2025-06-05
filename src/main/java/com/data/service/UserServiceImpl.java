package com.data.service;

import com.data.entity.User;
import com.data.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers(int page, int size) {
        return userRepository.getUsers(page, size);
    }

    @Override
    public long countUsers() {
        return userRepository.countUsers();
    }

    @Override
    public void toggleUserActive(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                user.setIsActive(!user.getIsActive());
                session.update(user);
            }
            session.getTransaction().commit();
        }
    }
}
