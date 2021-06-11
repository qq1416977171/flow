package com.qiang.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiang.dao.UserMapper;
import com.qiang.model.User;
import com.qiang.utils.PageBean;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(User user) {
		return userMapper.login(user);
	}

	@Override
	public void regist(User user) {
		userMapper.insert(user);
		
	}

	@Override
	public void add(User user) {
		userMapper.insert(user);
		
	}

	@Override
	public void delete(int uid) {
		userMapper.deleteByPrimaryKey(uid);
		
	}

	@Override
	public User findByUid(int uid) {
		
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public void edit(User user) {
		userMapper.updateByPrimaryKey(user);
		
	}

	@Override
	public List<User> findAll() {
		
		return userMapper.findAll();
	}
	
	
	//后台分页查询前台会员
	@Override
	public PageBean<User> pageAdminUser(int page) {
		PageBean<User> pagebean = new PageBean<User>();			
		// 设置当前页数:
		pagebean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pagebean.setLimit(limit);
		//设置总记录数
		int totalCount = 0;
		totalCount = userMapper.adminCount();
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
		List<User> list = userMapper.adminAll(begin,limit);
		pagebean.setList(list);
	return pagebean;
	}
	
	/**
	 * 根据用户名去查找用户是否存在
	 */
	@Override
	public User findByUsername(String username) {
		
		return userMapper.findByUsername(username);
	}

}
