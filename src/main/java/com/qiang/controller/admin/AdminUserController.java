package com.qiang.controller.admin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qiang.model.AdminUser;
import com.qiang.service.adminuser.AdminUserService;
import com.qiang.utils.PageBean;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;
	
	
	/**
	 * 后台登录页面
	 * @return
	 */
	@RequestMapping("")
	public String adminIndex(){
		return "admin/index";
	}

	/**
	 * 登录后的首页
	 * @return
	 */
	@RequestMapping("/home")
	public String home(HttpServletRequest request){
		HttpSession session = request.getSession();
		AdminUser adminUser = (AdminUser) session.getAttribute("existAdminUser");
		if (adminUser == null){
			return "index";
		}
		return "admin/home";
	}

	
	/**
	 * 后台登录
	 * @param request
	 * @param adminUser
	 * @return
	 */
	@RequestMapping("/adminUserController/adminLogin")
	public String adminLogin(HttpServletRequest request,AdminUser adminUser){
		if(adminUser.getUsername()==null || adminUser.getUsername()=="" ||adminUser.getPassword()==null||adminUser.getPassword()==""){
			request.setAttribute("msg","用户名密码不能为空");
			return "admin/index";
		}
		AdminUser existAdminUser = adminUserService.adminLogin(adminUser);
		if(existAdminUser!=null){
			//保存用户到session中
			request.getSession().setAttribute("existAdminUser", existAdminUser);
			return "admin/home";
		}else{
			request.setAttribute("msg","用户名密码不正确");
			return "admin/index";
		}	
	}
	
	/**
	 * 用户退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/adminUserController/quit")
	private String quit(HttpServletRequest request){		
		request.getSession().invalidate();
		return "admin/index";
	}
	
	
	
	
	/**
	 * 进入后台用户添加页面
	 * @return
	 */
	@RequestMapping("/adminUserController/toAdd")
	public String toAdd(AdminUser adminUser){		
		return "/admin/adminuser/add";
	}
	/**
	 * 后台用户添加
	 * @return
	 */
	@RequestMapping("/adminUserController/add")
	public String add(AdminUser adminUser){
		adminUserService.add(adminUser);
		return "redirect:findAllByPage?page=1";
	}
	/**
	 * 后台用户删除
	 * @return
	 */
	
	@RequestMapping("/adminUserController/delete")
	public String delete(int uid){
		adminUserService.delete(uid);
		return "redirect:findAllByPage?page=1";
	}
		
	/**
	 * 进入后台用户编辑界面
	 * @return
	 */
	@RequestMapping("/adminUserController/toEdit")
	public String toEdit(int uid,HttpServletRequest request){
		AdminUser adminUser = 	adminUserService.findByUid(uid);
		request.setAttribute("adminUser", adminUser);
		return "/admin/adminuser/edit";
	}
	
	/**
	 * 后台用户编辑
	 * @return
	 */
	@RequestMapping("/adminUserController/edit")
	public String edit(AdminUser adminUser){
		adminUserService.edit(adminUser);
		return "redirect:findAllByPage?page=1";
	}
	
	
	/**
	 * 后台用户查询
	 * @return
	 */
	@RequestMapping("/adminUserController/findAllByPage")
	public String findAllByPage(HttpServletRequest request,int page){
		//List<AdminUser> list = adminUserService.findAll();
		//request.setAttribute("list", list);
		PageBean<AdminUser> pageBean = adminUserService.pageAdminUser(page);
		request.getSession().setAttribute("pageBean", pageBean);
		
		return "/admin/adminuser/list";
	}	
}
