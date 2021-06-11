package com.qiang.dao;

import java.util.List;

import com.qiang.model.Category;
import com.qiang.model.CategorySecond;
import com.qiang.model.Flower;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cid);

    void insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

	List<Category> findAll();

	List<CategorySecond> findSecondByCid(int cid);

	List<Flower> findFlowerByCid(int cid);

	List<Category> findAll2();
}