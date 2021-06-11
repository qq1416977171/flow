package com.qiang.service.flower;

import com.github.pagehelper.PageHelper;
import com.qiang.dao.FlowerMapper;
import com.qiang.model.Flower;
import com.qiang.model.echarts;
import com.qiang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class FlowerServiceImpl implements FlowerService {
	
	@Autowired
	private FlowerMapper flowerMapper;

	@Override
	public List<Flower> isHot(Integer isHot) {
		
		PageHelper.startPage(1, 10);		
		return  flowerMapper.isHot(isHot);
	}

	@Override
	public List<Flower> isNew() {
		PageHelper.startPage(1, 10);
		return flowerMapper.isNew();
	}


	public List<echarts> findFlower() {

		return flowerMapper.findFlower();
	}

	@Override
	public Flower findByPid(int pid) {
		
		return flowerMapper.selectByPrimaryKey(pid);
	}
	
	
	//前台根据一级分类的id分页显示商品列表
	
	public PageBean<Flower> findFlowerByCid(int cid, int page) {

		PageBean<Flower> pagebean = new PageBean<Flower>();			
			// 设置当前页数:
			pagebean.setPage(page);
			// 设置每页显示记录数:
			int limit = 8;
			pagebean.setLimit(limit);
			//设置总记录数
			int totalCount = 0;
			totalCount = flowerMapper.findCount1(cid);
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
				map.put("cid",cid);
				//List<Product> list = productMapper.findProductByCid(cid);
			List<Flower> list = flowerMapper.findByPageCid(map);
			pagebean.setList(list);
		return pagebean;
	}

	
	//前台根据二级分类的id分页显示商品列表
	@Override
	public PageBean<Flower> findFlowerByCsid(int csid,int page) {
		
		//return productMapper.findAll();
		PageBean<Flower> pagebean = new PageBean<Flower>();			
		// 设置当前页数:
		pagebean.setPage(page);
		// 设置每页显示记录数:
		int size = 12;
		pagebean.setLimit(size);
		//设置总记录数
		int totalCount = 0;
		totalCount = flowerMapper.findCount2(csid);
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
			map.put("csid",csid);
		List<Flower> list = flowerMapper.findByPageCsid(map);
		pagebean.setList(list);
	   
		return pagebean;
	}

	@Override
	public void edit(Flower flower) {
		
		//productMapper.updateByPrimaryKey(product);
		flowerMapper.updateByPrimaryKeySelective(flower);
	}

	@Override
	public void delete(int pid) {
		flowerMapper.deleteByPrimaryKey(pid);	
	}

	@Override
	public void add(Flower flower) {
		flowerMapper.insert(flower);
		
	}

	/**
	 *后台分页查商品列表
	 */
	@Override
	public PageBean<Flower> findAllByPage(int page) {
		
		PageBean<Flower> pagebean = new PageBean<Flower>();			
		// 设置当前页数:
		pagebean.setPage(page);
		// 设置每页显示记录数:
		int size = 8;
		pagebean.setLimit(size);
		//设置总记录数
		int totalCount = 0;
		totalCount = flowerMapper.adminCount();
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
		List<Flower> list = flowerMapper.findAll(begin,size);
		pagebean.setList(list);
	   
		return pagebean;
	}
/*
	@Override
	public PageBean<Product> findByPrice(int page,double price) {
		
		PageBean<Product> pagebean = new PageBean<Product>();			
		// 设置当前页数:
		pagebean.setPage(page);
		// 设置每页显示记录数:
		int size = 8;
		pagebean.setLimit(size);
		//设置总记录数
		int totalCount = 0;
		totalCount = productMapper.adminCount();
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
		List<Product> list = productMapper.findByPrice(price,begin,size);
		pagebean.setList(list);
	   
		return pagebean;
	}
*/
}
