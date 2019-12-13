package com.example.batchdemo.service;

import com.example.batchdemo.dao.UserDao;
import com.example.batchdemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Map<Integer, User> findAllMap() {
        List<User> list = userDao.findAll();
        Map<Integer, User> userMap = new HashMap<>();
        for (User user : list) {
            userMap.put(user.getUserId(), user);
        }
        return userMap;
    }

    @Override
    public User get(int userId) {
        return userDao.get(userId);
    }

    @Override
    public User add(String userName) {
        User user = new User();
        user.setUserName(userName);
        userDao.insert(user);
        return user;
    }

    @Override
    public User update(int userId, String userName) {
        User user = this.get(userId);
        user.setUserName(userName);
        userDao.update(user);
        return user;
    }

    @Override
    public boolean delete(int userId) {
        userDao.delete(userId);
        return true;
    }

    @Override
    public void add(User user) {
        userDao.insert(user);
    }

    @Override
    public void batchInsert(List<User> userList) {
        userDao.batchInsert(userList);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public int batchUpdate(List<User> userList) {
        return userDao.batchUpdate(userList);
    }

    @Override
    public List<User> findLimit(int count) {
        return userDao.findLimit(count);
    }

}
