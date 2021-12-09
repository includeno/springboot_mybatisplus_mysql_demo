package com.example.demo.mapper;

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

import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    @Transactional
    @Rollback
    public void insert_test(){
        User user = GenObj.newUser();
        userMapper.insert(user);

        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        User result=userMapper.selectOne(wrapper);
        assert result.getEmail().equals(user.getEmail());
    }

    @Test
    @Transactional
    @Rollback
    public void select_test(){
        //demo.sql
        List<User> result = userMapper.selectList(null);
        assert result.size()==3;
    }

    @Test
    @Transactional
    @Rollback
    public void update_test(){
        User user = GenObj.newUser();
        userMapper.insert(user);

        //change name of user
        String oldName=user.getUsername();
        String newName=UUID.randomUUID().toString();
        user.setUsername(newName);
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",oldName);
        userMapper.update(user,wrapper);

        //new record exists
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",newName);
        User result=userMapper.selectOne(queryWrapper);
        assert result.getEmail().equals(user.getEmail());

        //no record of old name
        queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",oldName);
        result=userMapper.selectOne(queryWrapper);
        assert result==null;
    }

    @Test
    @Transactional
    @Rollback
    public void delete_test(){
        User user = GenObj.newUser();
        userMapper.insert(user);
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        userMapper.delete(wrapper);

        User result=userMapper.selectOne(wrapper);
        assert result==null;
    }

    @Test
    @Transactional
    @Rollback
    public void delete_one_test(){
        User user = GenObj.newUser();
        userMapper.insert(user);
        userMapper.deleteById(user.getId());

        User result=userMapper.selectById(user.getId());
        assert result==null;
    }

}
