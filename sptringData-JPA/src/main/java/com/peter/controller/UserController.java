package com.peter.controller;

import com.peter.pojo.User;
import com.peter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUser")
    public User getUser(Integer id){
        return userService.getUserById(id);
    }

    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        List<User> users = userService.getAllUserById();
        System.out.println(users.get(1).toString());
        return userService.getAllUserById();
    }

}
