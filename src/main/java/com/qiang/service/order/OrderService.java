package com.qiang.service.order;

import java.util.List;

import com.qiang.model.Order;
import com.qiang.model.OrderItem;
import com.qiang.model.OrderSet;
import com.qiang.utils.PageBean;

public interface OrderService {

	void save(Order order);

	PageBean<Order> findByUid(Integer uid,Integer page);
	
	List<OrderSet> findByOrderid(Integer oid);

	Order findByOid(Integer oid);

	void update(Order currOrder);

	List<Order> findAll();

	List<OrderItem> findOrderItem(Integer oid);

	PageBean<Order> findAllSecond(int page);

}
