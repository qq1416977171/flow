package com.qiang.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qiang.model.AdminUser;

public class AdminLoginIntercepter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		//获取url
		String url = arg0.getRequestURI();
		//如果是登录页面 放行
				if(url.indexOf("adminLogin")>=0){
					return true;
				}
				//获取session
				HttpSession session =  arg0.getSession();
				AdminUser AdminUser1 = (AdminUser) session.getAttribute("existAdminUser");
				
				//判断用户是否已经登录
				if(AdminUser1 !=null){
					return true;
				}else{
					arg0.getRequestDispatcher("/admin.do").forward(arg0, arg1);
					return false;
				}
	}

}
