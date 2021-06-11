package com.qiang.dao;

import java.util.List;

import com.qiang.model.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

	List<OrderItem> findOrderItem(Integer oid);
}