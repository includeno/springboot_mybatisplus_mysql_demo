package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.MainApplication;
import com.example.demo.entity.User;
import com.example.demo.util.GenObj;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @Transactional
    @Rollback
    public void insert_test(){
        User user = GenObj.newUser();
        userService.save(user);
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        User result=userService.getOne(wrapper);
        assert result.getEmail().equals(user.getEmail());
    }

    @Test
    @Transactional
    @Rollback
    public void select_test(){
        List<User> result = userService.list();
        assert result.size()==3;
    }

    @Test
    @Transactional
    @Rollback
    public void update_test(){
        User user = GenObj.newUser();
        userService.save(user);

        //change name of user
        String oldName=user.getUsername();
        String newName=UUID.randomUUID().toString();
        user.setUsername(newName);
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",oldName);
        userService.update(user,wrapper);

        //new record exists
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",newName);
        User result=userService.getOne(queryWrapper);
        assert result.getEmail().equals(user.getEmail());

        //no record of old name
        queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",oldName);
        result=userService.getOne(queryWrapper);
        assert result==null;
    }

    @Test
    @Transactional
    @Rollback
    public void delete_test(){
        User user = GenObj.newUser();
        userService.save(user);
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        userService.remove(wrapper);

        User result=userService.getOne(wrapper);
        assert result==null;
    }

    @Test
    @Transactional
    @Rollback
    public void delete_one_test(){
        User user = GenObj.newUser();
        userService.save(user);
        userService.removeById(user.getId());

        User result=userService.getById(user.getId());
        assert result==null;
    }
}