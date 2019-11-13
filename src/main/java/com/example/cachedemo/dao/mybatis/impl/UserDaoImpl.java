package com.example.cachedemo.dao.mybatis.impl;

import com.example.cachedemo.dao.UserDao;
import com.example.cachedemo.dao.mybatis.mapper.UserMapper;
import com.example.cachedemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("mybatis")
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User get(int userId) {
        return userMapper.get(userId);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(int userId) {
        userMapper.delete(userId);
    }

    @Override
    public int batchInsert(List<User> userList) {
        return userMapper.batchInsert(userList);
    }

    @Override
    public int batchUpdate(List<User> userList) {
        return userMapper.batchUpdate(userList);
    }

    @Override
    public List<User> findLimit(int count) {
        return userMapper.selectByLimit(count);
    }
}
