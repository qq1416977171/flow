package com.qiang.controller;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiang.model.Flower;
import com.qiang.service.categorysecond.CategorySecondService;
import com.qiang.utils.PageBean;

@Controller
public class CategorySecondController {
	
	@Autowired
	private CategorySecondService categorySecondService; 
	
	/**
	 * 首页搜索框搜索鲜花
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/findFlowerByCsName")
	private String findFlowerByCsName(Model model,int page,HttpServletRequest request) throws UnsupportedEncodingException{
		String csname = request.getParameter("csname");
	    
		PageBean<Flower> pageBean = categorySecondService.findFlowerByCsName(csname,page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("csname", csname);
		return "flowerList";
		
	}
	
	
}
