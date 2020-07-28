package com.luban.service;

import com.luban.pojo.Order;

import java.util.List;

public interface OrderService {
    Integer insertOrder(Order order);

    Order selectOrderById(Integer id);

    List<Order> selectOrderyAll();

//    R synchronizedSelectOrderById(Integer id);
}
