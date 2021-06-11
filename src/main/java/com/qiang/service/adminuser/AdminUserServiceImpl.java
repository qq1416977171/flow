package com.qiang.service.adminuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiang.dao.AdminUserMapper;
import com.qiang.model.AdminUser;
import com.qiang.utils.PageBean;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserMapper adminUserMapper;

	@Override
	public AdminUser adminLogin(AdminUser adminUser) {
		
		return adminUserMapper.adminLogin(adminUser);
	}

	@Override
	public void add(AdminUser adminUser) {
		adminUserMapper.insert(adminUser);
		
	}

	@Override
	public void delete(int uid) {
		
		adminUserMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public void edit(AdminUser adminUser) {
		
		adminUserMapper.updateByPrimaryKey(adminUser);
	}

	@Override
	public List<AdminUser> findAll() {
		
		return adminUserMapper.findAll();
		
	}

	@Override
	public AdminUser findByUid(int uid) {
		
		return adminUserMapper.findByUid(uid);
	}

	@Override
	public PageBean<AdminUser> pageAdminUser(int page) {
		PageBean<AdminUser> pagebean = new PageBean<AdminUser>();			
		// 设置当前页数:
		pagebean.setPage(page);
		// 设置每页显示记录数:
		int size = 8;
		pagebean.setLimit(size);
		//设置总记录数
		int totalCount = 0;
		totalCount = adminUserMapper.findCount();
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
		List<AdminUser> list = adminUserMapper.pageAdminUser(begin,size);
		pagebean.setList(list);
	   
		return pagebean;
		
	}
}
