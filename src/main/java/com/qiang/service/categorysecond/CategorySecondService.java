package com.qiang.service.categorysecond;



import java.util.List;

import com.qiang.model.CategorySecond;
import com.qiang.model.Flower;
import com.qiang.utils.PageBean;

public interface CategorySecondService {

	

	PageBean<CategorySecond> findAllSecond(int page);

	void add(CategorySecond categorySecond);

	void delete(int csid);

	CategorySecond findByCsid(int csid);

	void edit(CategorySecond categorySecond);

	List<CategorySecond> findAllSecond();

	PageBean<Flower> findFlowerByCsName(String csname,int page);
}
