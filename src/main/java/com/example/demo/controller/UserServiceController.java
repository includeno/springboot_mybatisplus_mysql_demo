package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/service")
public class UserServiceController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public boolean insertUser(User user){
        user.setCreateTime(new Date());
        return userService.save(user);
    }
    @GetMapping("/user")
    public User getUser(Integer id){
        return userService.getById(id);
    }
    @PutMapping("/user")
    public boolean updateUser(User user){
        return userService.save(user);
    }
    @DeleteMapping("/user")
    public boolean deleteUser(User user){
        return userService.removeById(user.getId());
    }
}