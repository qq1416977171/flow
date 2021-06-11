package com.qiang.service.category;

import java.util.List;

import com.qiang.model.Category;
import com.qiang.model.CategorySecond;
import com.qiang.model.Flower;

public interface CategoryService {

	List<Category> findAll();

	List<CategorySecond> findSecondByCid(int cid);

	List<Flower> findFlowerByCid(int cid);

	void add(Category category);

	void delete(int cid);

	void edit(Category category);

	Category findByCid(int cid);

	List<Category> findAll2();

	

}
