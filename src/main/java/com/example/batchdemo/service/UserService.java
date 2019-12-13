package com.example.batchdemo.service;

import com.example.batchdemo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();

    Map<Integer, User> findAllMap();

    User get(int userId);

    User add(String userName);

    User update(int userId, String userName);

    boolean delete(int userId);

    void add(User user);

    void batchInsert(List<User> userList);

    void update(User user);

    int batchUpdate(List<User> userList);

    List<User> findLimit(int count);

}
