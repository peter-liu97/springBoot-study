package com.luban.controller;

import com.luban.pojo.Order;
import com.luban.pojo.R;
import com.luban.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    RedisTemplate redisTemplate;

//    @GetMapping("/test")
    public Integer insertOrder(Order order){

        return orderService.insertOrder(order);
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return "test";
    }


    @GetMapping("/selectid")
    public R selectOrderById(Integer id){
        System.out.println(id);
        return orderService.selectOrderById(id);
    }
}
