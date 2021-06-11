package com.qiang.service.categorysecond;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiang.dao.CategorySecondMapper;
import com.qiang.dao.FlowerMapper;
import com.qiang.model.CategorySecond;
import com.qiang.model.Flower;
import com.qiang.utils.PageBean;
@Service
public class CategorySecondServiceImpl implements CategorySecondService {
	
	@Autowired
	private CategorySecondMapper categorySecondMapper;
	
	@Autowired
	private FlowerMapper flowerMapper;
	
	@Override
	public PageBean<CategorySecond> findAllSecond(int page) {
		PageBean<CategorySecond> pagebean = new PageBean<CategorySecond>();			
		// 设置当前页数:
		pagebean.setPage(page);
		// 设置每页显示记录数:
		int size = 8;
		pagebean.setLimit(size);
		//设置总记录数
		int totalCount = 0;
		totalCount = categorySecondMapper.findCount();
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
		List<CategorySecond> list = categorySecondMapper.findAllSecond(begin,size);
		pagebean.setList(list);
	   
		return pagebean;
		
	}
	@Override
	public void add(CategorySecond categorySecond) {
		categorySecondMapper.insert(categorySecond);
		
	}
	@Override
	public void delete(int csid) {
		categorySecondMapper.deleteByPrimaryKey(csid);
		
	}
	@Override
	public CategorySecond findByCsid(int csid) {
		
		return categorySecondMapper.selectByPrimaryKey(csid);
	}
	@Override
	public void edit(CategorySecond categorySecond) {
		categorySecondMapper.updateByPrimaryKey(categorySecond);
		
	}
	@Override
	public List<CategorySecond> findAllSecond() {
		return categorySecondMapper.findAll();
	}
	
	/**
	 * 首页搜索框搜索鲜花
	 * @return
	 */
	@Override
	public PageBean<Flower> findFlowerByCsName(String csname,int page) {
		
		PageBean<Flower> pagebean = new PageBean<Flower>();			
		// 设置当前页数:
		pagebean.setPage(page);
		// 设置每页显示记录数:
		int size = 20;
		pagebean.setLimit(size);
		//设置总记录数
		int totalCount = 0;
		totalCount = flowerMapper.findCount3(csname);
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
			Map<String,Object> map = new HashMap<String, Object>();
	        map.put("begin",begin);
	        map.put("size",size);
			map.put("csname",csname);
		List<Flower> list = flowerMapper.findAllByCsName(map);
		pagebean.setList(list);
		return pagebean;
		
	}	
}
