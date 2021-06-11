package com.qiang.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiang.model.User;
import com.qiang.service.user.UserService;
import com.qiang.utils.PageBean;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 注册用户
	 * @return
	 */
	@RequestMapping("/toRegist")
	public String toRegist(){		
		return "regist";
	}
	
	@RequestMapping("/regist")
	public String regist(User user,Model model,String checkcode,HttpServletRequest request){
		String SessionCode = (String) request.getSession().getAttribute("code");
		if(!checkcode.equalsIgnoreCase(SessionCode)){
			model.addAttribute("msg", "验证码不正确！");
			return "regist";
		}
		//后台判断用户名是否已经存在
		User user2 = userService.findByUsername(user.getUsername());
		if(user2!=null){
			request.setAttribute("msg", "<font color='red'>用户名已经存在！！！</font>");
			return "regist";
		}
		userService.regist(user);
		model.addAttribute("existUser", user);
		request.setAttribute("msg", "注册成功，请登录");
		return "msg";
	}
	
	/**
	 * 登录
	 * @return
	 */
	
	@RequestMapping("/toLogin")
	public String toLogin(){		
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(User user,Model model,HttpServletRequest request){
		User existUser = userService.login(user);
		if(existUser!=null){
			//model.addAttribute("existUser", user);
			request.getSession().setAttribute("existUser", existUser);//必须放在session中重定向到主页面才能取到值
			System.out.println(existUser.getName());
			return "redirect:/";
		}else{
			if(user.getUsername()==null || "".equals(user.getUsername().trim())){
				request.setAttribute("msg", "用户名不能为空！");
				
			}else if(user.getPassword()==null || "".equals(user.getPassword().trim())){
				request.setAttribute("msg", "密码不能为空！");
				
			}else{
				request.setAttribute("msg", "用户名密码不正确！");
			}
			return "login";
		}
		
	}
	
	/**
	 * 消息模块
	 * @return
	 */
	@RequestMapping("/msg")
	public String msg(){
		return "msg";
	}
	
	/**
	 * 前台会员修改密码
	 * @return
	 */
	@RequestMapping("/ToEditPassword")
	private String ToeditPassword(){
		return "editPassword";
	}
	
	@RequestMapping("/editPassword")
	private String editPassword(HttpServletRequest request,int uid){
		String password = (String) request.getParameter("password");
		String password2 = (String) request.getParameter("password2");
		if(!password.equals(password2)){
			request.setAttribute("msg", "两次密码输入不一致");
			return "editPassword";
		}
		User user = userService.findByUid(uid);
		user.setPassword(password);
		userService.edit(user);
		return "redirect:/user/toLogin";
		
		
		
	}
	
	
	
	/**
	 * 根据用户名查询用户是否已经存在
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/findByUsername")
	private void findByUsername(HttpServletRequest request,HttpServletResponse response) throws IOException{	
		
		//接收的参数进行UTF-8转码
		String name= (String) request.getParameter("username");
		String name2= new String(name.getBytes("ISO-8859-1"),"UTF-8");
		
		User user = userService.findByUsername(name2);
		
		if(user==null){
			
			//设置页面提示字符编码UTF-8
			response.setContentType("text/html;charset=UTF-8");
			
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}else{
			
			//设置页面提示字符编码UTF-8
			response.setContentType("text/html;charset=UTF-8");
			
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}
	}
	
	
	
	/**
	 * 用户退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/quit")
	private String quit(HttpServletRequest request){		
		request.getSession().invalidate();
		return "index";
	}
	
	
	/**
	 * 后台用户添加
	 * @return
	 */
	@RequestMapping("/add")
	public String add(User user){
		userService.add(user);
		return "redirect:findAll?page=1";
	}
	/**
	 * 后台用户删除
	 * @return
	 */
	
	@RequestMapping("/delete")
	public String delete(int uid){
		userService.delete(uid);
		return "redirect:findAll?page=1";
	}
	
	
	/**
	 * 进入后台用户编辑界面
	 * @return
	 */
	@RequestMapping("/toEdit")
	public String toEdit(int uid,HttpServletRequest request){
		User user = userService.findByUid(uid);
		request.setAttribute("user", user);
		return "/admin/user/edit";
	}
	
	/**
	 * 后台用户编辑
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(User user){
		userService.edit(user);
		return "redirect:findAll?page=1";
	}
	
	
	/**
	 * 后台用户查询
	 * @return
	 */
	@RequestMapping("/findAll")
	public String findAll(HttpServletRequest request,int page){
		//List<User> list = userService.findAll();		
		//request.setAttribute("list", list);
		PageBean<User> pageBean = userService.pageAdminUser(page);
		request.getSession().setAttribute("pageBean", pageBean);
		return "/admin/user/list";
	}
	

}
