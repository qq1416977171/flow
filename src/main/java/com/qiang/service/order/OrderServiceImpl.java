package com.qiang.service.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiang.dao.OrderMapper;
import com.qiang.model.Order;
import com.qiang.model.OrderItem;
import com.qiang.model.OrderSet;
import com.qiang.utils.PageBean;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public void save(Order order) {
		orderMapper.insert(order);
		
	}

	@Override
	public PageBean<Order> findByUid(Integer uid,Integer page){   //List<Order> findByUid(Integer uid) {
		PageBean<Order> pagebean = new PageBean<Order>();
		// 设置当前页数:
		pagebean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pagebean.setLimit(limit);
		//设置总记录数
		int totalCount = 0;
		totalCount = orderMapper.findCount(uid);
		pagebean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit ==0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit +1;
		}
		pagebean.setTotalPage(totalPage);
		//设置每页显示的数据集合:
			//从哪个地方开始显示
			int begin = (page-1) * limit;
			Map<String,Object> map = new HashMap<String, Object>();
	        map.put("begin",begin);
	        map.put("limit",limit);
			map.put("uid",uid);				
		List<Order> orders = orderMapper.findByUid(map);
		pagebean.setList(orders);
		return pagebean;
	}

	@Override
	public Order findByOid(Integer oid) {
		
		return orderMapper.findByOid(oid);
	}
	
	@Override
	public List<OrderSet> findByOrderid(Integer oid) {
		
		return orderMapper.findByOrderid(oid);
	}

	@Override
	public void update(Order currOrder) {
		orderMapper.updateByPrimaryKeySelective(currOrder);
		
	}

	@Override
	public List<Order> findAll() {
		
		return orderMapper.findAll();
	}

	@Override
	public List<OrderItem> findOrderItem(Integer oid) {
		
		return orderMapper.findOrderItem(oid);
	}
	
	
	//后台分页查询订单信息
	@Override
	public PageBean<Order> findAllSecond(int page) {
		PageBean<Order> pagebean = new PageBean<Order>();			
		// 设置当前页数:
		pagebean.setPage(page);
		// 设置每页显示记录数:
		int size = 8;
		pagebean.setLimit(size);
		//设置总记录数
		int totalCount = 0;
		totalCount = orderMapper.adminCount();
		pagebean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % size ==0){
			totalPage = totalCount / size;
		}else{
			totalPage = totalCount / size +1;
		}
		pagebean.setTotalPage(totalPage);
		//设置每页显示的数据集合:
			//从哪个地方开始显示
			int begin = (page-1) * size;
			//pagebean.setBegin(begin);
			//List<Product> list = productMapper.findByPage()
		List<Order> list = orderMapper.findAllSecond(begin,size);
		pagebean.setList(list);
	   
		return pagebean;
	}

}
