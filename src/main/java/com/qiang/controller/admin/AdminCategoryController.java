package com.qiang.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiang.model.Category;
import com.qiang.service.category.CategoryService;
@Controller
@RequestMapping("/admin/adminCategoryController")
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;


	/**
	 * 添加一级分类
	 * @param category
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd(){

		return "/admin/category/add";
	}


	@RequestMapping("/add")
	public String add(Category category,HttpServletRequest request){
		categoryService.add(category);

		return "redirect:list";
	}


	/**
	 * 删除一级分类
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(int cid){
		categoryService.delete(cid);
		return "redirect:list";
	}


	/**
	 * 一级分类列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		List<Category> list = categoryService.findAll2();
		request.getSession().setAttribute("list", list);
		return "/admin/category/list";
	}


	/**
	 * 编辑一级分类
	 * @return
	 */
	/**
	 * @param cid
	 * @param request
	 * @return
	 */
	@RequestMapping("/toEdit")
	public String toEdit(int cid,HttpServletRequest request){
		Category category = categoryService.findByCid(cid);
		request.getSession().setAttribute("category", category);
		return "/admin/category/edit";
	}

	@RequestMapping("/edit")
	public String edit(Category category){
		categoryService.edit(category);
		return "redirect:list";
	}
}
