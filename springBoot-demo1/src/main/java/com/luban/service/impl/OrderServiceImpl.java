package com.luban.service.impl;


import com.luban.mapper.OrderMapper;
import com.luban.pojo.Order;
import com.luban.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public Integer insertOrder(Order order) {

        return null;
    }

    @Override
    public Order selectOrderById(Integer id) {
        return orderMapper.selectOrderById(id);
    }

    @Override
    public List<Order> selectOrderyAll() {
        return null;
    }
}
