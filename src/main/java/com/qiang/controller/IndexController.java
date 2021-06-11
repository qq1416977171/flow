package com.qiang.controller;

import java.util.List;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiang.model.Category;
import com.qiang.model.Flower;
import com.qiang.service.category.CategoryService;
import com.qiang.service.flower.FlowerService;


@Controller
@RequestMapping("")
public class IndexController {	
	@Autowired
	private FlowerService flowerService;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 前台主页
	 * @param model
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model,HttpServletRequest request){
		
		//前台查询所有的一级分类,并且关联查询出了页面左侧的二级分类
		List<Category> cList = categoryService.findAll();
		request.getSession().setAttribute("cList", cList);
		
		
		//查询是否是热门商品			1热门   0非热门
		List<Flower> hList = flowerService.isHot(1);		
		model.addAttribute("hList", hList);

				
		//查询最新的商品
		List<Flower> nList = flowerService.isNew();
		model.addAttribute("nList", nList);
		return "index";
	}
	
	/**
	 * 一分钟教你如何选花
	 * @return
	 */
	@RequestMapping("/help")
	public String oneSelect(){	
		return "help";
	}
	
	@RequestMapping("/Code")
	public String Code(){	
		return "Code";
	}
	
	
	

}
