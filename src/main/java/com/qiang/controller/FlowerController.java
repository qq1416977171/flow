package com.qiang.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiang.model.Flower;
import com.qiang.service.flower.FlowerService;
import com.qiang.utils.PageBean;

@Controller
@RequestMapping("/flower")
public class FlowerController {
	
	@Autowired
	private FlowerService flowerService;
	
	//进入商品详情页面
	@RequestMapping("/findByPid")
	public String findByPid(int pid,Model model){
		
		Flower flower = flowerService.findByPid(pid);
		model.addAttribute("flower", flower);
		return "flower";
		
	}
	
	//根据一级分类id分页查找商品
	@RequestMapping("/findFlowerByCid")
	public String findFlowerByCid(int cid,int page,Model model){
		
		PageBean<Flower> pageBean = flowerService.findFlowerByCid(cid,page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("cid", cid);
		return "flowerList";
	}
		
	//根据二级分类id查找商品
		@RequestMapping("/findFlowerByCsid")
		private String findFlowerByCsid(int csid,int page,Model model){
						
			PageBean<Flower> pageBean = flowerService.findFlowerByCsid(csid,page);
			model.addAttribute("pageBean", pageBean);
			model.addAttribute("csid", csid);
			return "flowerList";
		}
}
