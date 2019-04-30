package com.example.demo.spring.service;

import com.example.demo.mybatis.bean.User;
import com.example.demo.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public List<User> getAllUsers(){
        List<User> list = new ArrayList<User>();
        list.addAll(mapper.selectAll());
        //list = mapper.selectAll();
        return list;
    }

    public int addUser(User user) {
        return mapper.insert(user);
    }

    @CachePut(value="usercache", key="'user_'.concat(#user.loginName)")
    public User updateUser(User user){
        mapper.updateName(user);
        return user;
    }

    //@Cacheable(value="usercache",keyGenerator = "keyGenerator")
    @Cacheable(value="usercache", key="'user_'.concat(#name)", unless="#result==null")
    public User getUserByName(String name) {
        List<User> list = mapper.getUserByName(name);
        if(list.size()==0){
            return null;
        }
        return mapper.getUserByName(name).get(0);
    }

    public int deleteUser(String loginname) {
        return mapper.deleteByLoginName(loginname);
    }
}
