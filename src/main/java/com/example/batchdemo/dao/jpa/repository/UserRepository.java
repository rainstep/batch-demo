package com.example.batchdemo.dao.jpa.repository;

import com.example.batchdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUserId(int userId);
}
