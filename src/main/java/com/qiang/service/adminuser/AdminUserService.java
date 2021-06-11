package com.qiang.service.adminuser;

import java.util.List;

import com.qiang.model.AdminUser;
import com.qiang.utils.PageBean;

public interface AdminUserService {

	AdminUser adminLogin(AdminUser adminUser);

	void add(AdminUser adminUser);

	void delete(int uid);

	void edit(AdminUser adminUser);

	List<AdminUser> findAll();

	AdminUser findByUid(int uid);

	PageBean<AdminUser> pageAdminUser(int page);

}
