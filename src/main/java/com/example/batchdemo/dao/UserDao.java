package com.example.batchdemo.dao;

import com.example.batchdemo.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User get(int userId);

    void insert(User user);

    void update(User user);

    void delete(int userId);

    int batchInsert(List<User> userList);

    int batchUpdate(List<User> userList);

    List<User> findLimit(int count);

}
