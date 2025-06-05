package com.data.service;

import com.data.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(int page, int size);
    long countUsers();
    void toggleUserActive(Long id);
}
