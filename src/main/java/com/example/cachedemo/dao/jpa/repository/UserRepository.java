package com.example.cachedemo.dao.jpa.repository;

import com.example.cachedemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUserId(int userId);
}
