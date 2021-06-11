package com.qiang.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiang.dao.CategoryMapper;
import com.qiang.model.Category;
import com.qiang.model.CategorySecond;
import com.qiang.model.Flower;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> findAll() {
		
		return categoryMapper.findAll();
	}

	@Override
	public List<CategorySecond> findSecondByCid(int cid) {
		
		return categoryMapper.findSecondByCid(cid);
	}
	
	//根据一级分类id查找商品
	@Override
	public List<Flower> findFlowerByCid(int cid) {
		
		return categoryMapper.findFlowerByCid(cid);
	}

	@Override
	public void add(Category category) {
		
		 categoryMapper.insert(category);
	}

	@Override
	public void delete(int cid) {
		categoryMapper.deleteByPrimaryKey(cid);
		
	}

	@Override
	public void edit(Category category) {
		categoryMapper.updateByPrimaryKey(category);
		
	}

	@Override
	public Category findByCid(int cid) {
	
		return 	categoryMapper.selectByPrimaryKey(cid);
		
	}

	@Override
	public List<Category> findAll2() {
		return categoryMapper.findAll2();
	}
}
