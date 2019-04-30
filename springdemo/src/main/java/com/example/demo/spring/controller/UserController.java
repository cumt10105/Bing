package com.example.demo.spring.controller;

import com.example.demo.mybatis.bean.User;
import com.example.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/getAllUsers")
    public List<User> getUsers(){
        List<User> list = service.getAllUsers();
        return list;
    }

    @RequestMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name){
        return service.getUserByName(name);
    }

    @RequestMapping(value="/adduser", method= RequestMethod.POST)
    public int adduser(@RequestBody User user){
        int userid = service.addUser(user);
        return userid;
    }

    @RequestMapping(value="/updateUser", method= RequestMethod.PUT)
    public void updateuser(@RequestBody User user){
        service.updateUser(user);
    }

    @RequestMapping(value="/deleteUser/{loginname}", method= RequestMethod.DELETE)
    public void deleteUser(@PathVariable String loginname){
        service.deleteUser(loginname);
    }
}
