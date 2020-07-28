package com.luban.mapper;

import com.luban.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("insert into t_order (id,name) values (#{id},#{name})")
    Integer insertOrder(Order order);

    @Select("select * from t_order where id=#{id}")
    Order selectOrderById(Integer id);

    @Select("select * from t_order")
    List<Order> selectOrderyAll();
}
