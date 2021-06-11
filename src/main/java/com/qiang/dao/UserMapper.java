package com.qiang.dao;

import java.util.List;

import com.qiang.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User user);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User login(User user);

	List<User> findAll();
	List<User> adminAll(Integer begin, Integer limit);
	int adminCount();

	User findByUsername(String username);
}