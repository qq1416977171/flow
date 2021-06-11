package com.qiang.controller.admin;

import java.io.File;

import java.util.*;


import javax.servlet.http.HttpServletRequest;

import com.qiang.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qiang.service.category.CategoryService;
import com.qiang.service.categorysecond.CategorySecondService;
import com.qiang.service.flower.FlowerService;
import com.qiang.utils.PageBean;
import com.qiang.utils.WebUtils;
@Controller
@RequestMapping("/admin/adminFlowerController")
public class AdminFlowerController {

	@Autowired
	private FlowerService flowerService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategorySecondService categorySecondService;

	/**
	 * 后台商品的添加
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd(HttpServletRequest request){

		List<CategorySecond> list = categorySecondService.findAllSecond();
		request.setAttribute("list", list);
		return "/admin/flower/add";
	}



	@RequestMapping("/add")
	public String add(Flower flower, HttpServletRequest request,
					  @RequestParam(value = "upload", required = false) MultipartFile file){
		String imageAddr = WebUtils.saveFile(request, file);
		flower.setImage(imageAddr);
		flower.setPdate(new Date());
		flowerService.add(flower);
		return "redirect:list?page=1";
	}



	/**
	 * 后台商品的删除
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(int pid){
		//1.删除磁盘上的图片
		Flower flower = flowerService.findByPid(pid);
		String delPath = "${ pageContext.request.contextPath }\\xianhua\\"
				+ flower.getImage();
		System.out.println(delPath);
		File file = new File(delPath);
		file.delete();

		//2.再删除数据库记录
		flowerService.delete(pid);
		return "redirect:list.action?page=1";
	}

	/**
	 * 后台商品的编辑
	 * @return
	 */
	@RequestMapping("/toEdit")
	public String toEdit(int pid, HttpServletRequest request){
		Flower flower = flowerService.findByPid(pid);
		request.setAttribute("flower", flower);

		//所属一级分类
		List<Category> clist =categoryService.findAll2();
		request.setAttribute("clist", clist);
		//所属二级分类
		List<CategorySecond> list = categorySecondService.findAllSecond();
		request.setAttribute("list", list);
		return "/admin/flower/edit";

	}


	@RequestMapping("/edit")
	public String edit(Flower flower,HttpServletRequest request,
					   @RequestParam(value = "upload", required = false) MultipartFile file){


		if(file.getSize()!=0){

			//1.先删除原来的图片
			String delPath = "G:\\JingShui\\src\\main\\webapp\\"
					+ flower.getImage();

			System.out.println(delPath);
			File file1 = new File(delPath);
			file1.delete();


			//2.上传新的图片
			String imageAddr = WebUtils.saveFile(request, file);
			flower.setImage(imageAddr);
		}




		flower.setPdate(new Date());
		flowerService.edit(flower);
		return "redirect:list?page=1";
	}

	/**
	 * 后台商品列表分页查看
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request,int page){
		PageBean<Flower> pList = flowerService.findAllByPage(page);
		request.setAttribute("pList", pList);
		return "/admin/flower/list";
	}

	@ResponseBody
	@RequestMapping(method= RequestMethod.GET,value = "/echarts")
	public List echarts(){
		System.out.println("*****");
		List<echarts> flower = flowerService.findFlower();

		System.out.println(flower);


		return flower;
	}




}
