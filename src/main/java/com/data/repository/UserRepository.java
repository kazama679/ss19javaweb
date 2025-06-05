package com.data.repository;

import com.data.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers(int page, int size);
    long countUsers();
}
