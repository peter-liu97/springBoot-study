package com.luban.service;

import com.luban.pojo.Order;
import com.luban.pojo.R;

import java.util.List;

public interface OrderService {
    Integer insertOrder(Order order);

    R selectOrderById(Integer id);

    List<Order> selectOrderyAll();

//    R synchronizedSelectOrderById(Integer id);
}
