package com.luban.controller;

import com.luban.properties.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class TestController {

    @Autowired
    Student student;


    @Value("${a}")
    String a;


    @RequestMapping("test")
    public Object test(){

        System.out.println(student);
        System.out.println(a);
        System.out.println("test");
        return "test";
    }
}
