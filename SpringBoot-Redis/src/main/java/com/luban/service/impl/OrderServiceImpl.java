package com.luban.service.impl;


import com.luban.mapper.OrderMapper;
import com.luban.pojo.Order;
import com.luban.pojo.R;
import com.luban.service.OrderService;
import com.luban.template.CacheLoadble;
import com.luban.template.CacheTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CacheTemplate cacheTemplate;

    @Override
    public Integer insertOrder(Order order) {

        return null;
    }

    @Override
    public R selectOrderById(Integer id) {
        return cacheTemplate.redisFindCache(String.valueOf(id), 10, TimeUnit.MINUTES, new CacheLoadble<Order>() {
            @Override
            public Order load() {
                return orderMapper.selectOrderById(id);
            }
        },true);
    }


    @Override
    public List<Order> selectOrderyAll() {
        return orderMapper.selectOrderyAll();
    }
}
