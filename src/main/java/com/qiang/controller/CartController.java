package com.qiang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiang.model.Cart;
import com.qiang.model.CartItem;
import com.qiang.model.Flower;
import com.qiang.model.User;
import com.qiang.service.flower.FlowerService;

@Controller
@RequestMapping("/cartController")
public class CartController {
	@Autowired
	private FlowerService flowerService;
	
	// 将购物项添加到购物车:执行的方法
	@RequestMapping("/addCart")
	public String addCart(int count,int pid,HttpServletRequest request) {
	
		//判断是否登录
		User existUser = (User) request.getSession().getAttribute("existUser");
		if(existUser==null){
			return "login";
		}
		// 封装一个CartItem对象.
		CartItem cartItem = new CartItem();
		// 设置数量:
		cartItem.setCount(count);
		// 根据pid进行查询商品:
		Flower flower = flowerService.findByPid(pid);
		// 设置商品:
		cartItem.setProduct(flower);
		// 将购物项添加到购物车.
		// 购物车应该存在session中.
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		cart.addCart(cartItem);

		return "cart";
   }

		// 清空购物车的执行的方法:
	@RequestMapping("/clearCart")
	public String clearCart(HttpServletRequest request){
		// 获得购物车对象.
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		// 调用购物车中清空方法.
		cart.clearCart();
		return "cart";
	}
		
	// 从购物车中移除购物项的方法:
	@RequestMapping("/removeCart")
		public String removeCart(int pid,HttpServletRequest request){
			// 获得购物车对象
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
			// 调用购物车中移除的方法:
			cart.removeCart(pid);
			// 返回页面:
			return "cart";
		}
		
	// 我的购物车:执行的方法
	@RequestMapping("/myCart")
	public String myCart(HttpServletRequest request){
	
		//判断是否登录
		User existUser = (User) request.getSession().getAttribute("existUser");
		if(existUser==null){
			request.setAttribute("msg", "亲!您还没有登录");
			return "login";
		}
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession()
					.setAttribute("cart", cart);
		}
		return "cart";
	}
}
