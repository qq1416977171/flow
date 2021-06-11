package com.qiang.dao;

import java.util.List;

import com.qiang.model.AdminUser;

public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

	AdminUser adminLogin(AdminUser record);

	List<AdminUser> findAll();

	AdminUser findByUid(int uid);

	
	
	//分页查询
	int findCount();

	List<AdminUser> pageAdminUser(int begin, int size);
}