package com.example.cachedemo.dao.jpa.impl;

import com.example.cachedemo.dao.UserDao;
import com.example.cachedemo.dao.jpa.repository.UserRepository;
import com.example.cachedemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("jpa")
@Repository
public class UserDaoJpaImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(int userId) {
        return userRepository.getByUserId(userId);
    }

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public int batchInsert(List<User> userList) {
        userRepository.saveAll(userList);
        return userList.size();
    }

    @Override
    public int batchUpdate(List<User> userList) {
        userRepository.saveAll(userList);
        return userList.size();
    }

    @Override
    public List<User> findLimit(int count) {
        Page<User> userPage = userRepository.findAll(PageRequest.of(0, count));
        return userPage.getContent();
    }
}
