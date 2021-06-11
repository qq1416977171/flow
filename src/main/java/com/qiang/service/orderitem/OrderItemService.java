package com.qiang.service.orderitem;

import java.util.List;

import com.qiang.model.OrderItem;

public interface OrderItemService {

	List<OrderItem> findOrderItem(Integer oid);

	void insert(OrderItem orderItem);

}
