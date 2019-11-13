package com.example.cachedemo.controller;

import com.example.cachedemo.entity.User;
import com.example.cachedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.findAll();
    }

    @GetMapping("/map")
    public Map<Integer, User> map() {
        Map<Integer, User> allMap = userService.findAllMap();
        return allMap;
    }

    @GetMapping("/get/{userId}")
    public User list(@PathVariable int userId) {
        return userService.get(userId);
    }

    @PostMapping("/add")
    public User add(String userName) {
//        userService.clearCache();
        return userService.add(userName);
    }

    @PostMapping("/update")
    public User update(int userId, String userName) {
//        userService.clearCache();
        return userService.update(userId, userName);
    }

    @GetMapping("/delete/{userId}")
    public boolean delete(@PathVariable int userId) {
//        userService.clearCache();
        return userService.delete(userId);
    }

}
