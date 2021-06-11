package com.qiang.service.flower;

import java.util.List;

import com.qiang.model.Flower;
import com.qiang.model.echarts;
import com.qiang.utils.PageBean;

public interface FlowerService {

	List<Flower> isHot(Integer isHot);

	List<Flower> isNew();

	List<echarts> findFlower();

	Flower findByPid(int pid);	

	void edit(Flower flower);

	void delete(int pid);

	void add(Flower flower);

	PageBean<Flower> findAllByPage(int page);

	PageBean<Flower> findFlowerByCid(int cid,int page);

	PageBean<Flower> findFlowerByCsid(int csid, int page);

	

}
