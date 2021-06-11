package com.qiang.service.orderitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiang.dao.OrderItemMapper;
import com.qiang.model.OrderItem;
@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemMapper orderItemMapper;
	@Override
	public List<OrderItem> findOrderItem(Integer oid) {
		
		return orderItemMapper.findOrderItem(oid);
	}
	@Override
	public void insert(OrderItem orderItem) {
		
		orderItemMapper.insert(orderItem);
	}

}
