package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/mapper")
public class UserMapperController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/user")
    public int insertUser(User user){
        user.setCreateTime(new Date());
        return userMapper.insert(user);
    }
    @GetMapping("/user")
    public User getUser(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
    @PutMapping("/user")
    public int updateUser(User user){
        return userMapper.updateByPrimaryKey(user);
    }
    @DeleteMapping("/user")
    public int deleteUser(User user){
        return userMapper.deleteById(user.getId());
    }
}