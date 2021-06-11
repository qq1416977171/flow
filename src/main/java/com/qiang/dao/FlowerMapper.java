package com.qiang.dao;

import java.util.List;
import java.util.Map;

import com.qiang.model.Flower;
import com.qiang.model.echarts;

public interface FlowerMapper {


	List<echarts> findFlower();

    int deleteByPrimaryKey(Integer pid);

    int insert(Flower record);

    int insertSelective(Flower record);

    Flower selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Flower record);

    int updateByPrimaryKey(Flower record);

	List<Flower> isHot(Integer isHot);

	List<Flower> isNew();

	int findCount1(Integer cid);
	
	int findCount2(Integer csid);
	
	int findCount3(String csname);

	List<Flower> findByPageCid(Map<String,Object> map);

	List<Flower> findAll(int begin, int size);
	
	List<Flower> findFlowerByCsid(int csid);

	List<Flower> findFlowerByCid(int cid);

	List<Flower> findByPageCsid(Map<String,Object> map);

	int adminCount();

	List<Flower> findAllByCsName(Map<String,Object> map);
}