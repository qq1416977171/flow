package com.qiang.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiang.model.Cart;
import com.qiang.model.CartItem;
import com.qiang.model.Order;
import com.qiang.model.OrderItem;
import com.qiang.model.OrderSet;
import com.qiang.model.User;
import com.qiang.service.order.OrderService;
import com.qiang.service.orderitem.OrderItemService;
import com.qiang.utils.PageBean;
import com.qiang.utils.PaymentUtil;

@Controller
@RequestMapping("/orderController")
public class OrderController {
	
	@Autowired
	private OrderService orderService;	
	
	@Autowired
	private OrderItemService orderItemService;
	
	/**
	 * 提交订单
	 * @param request
	  * @return
	 */
	@RequestMapping("/saveOrder")
	private String saveOrder(Order order,HttpServletRequest request){	
		         
		//1.判断购物车是否为空
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart==null){
			request.setAttribute("msg", "亲!您还没有购物!购物车为空");
			return "msg";
		}
		//随机数生成1-10000
		Random random = new Random(System.currentTimeMillis());
		int iRandom = random.nextInt(10000)+1;
		order.setOid(iRandom);
		order.setTotal(cart.getTotal());
		order.setState(1);
		order.setOrdertime(new Date());
		//2.设置订单关联用户		
		User existUser = (User) request.getSession().getAttribute("existUser");
		if(existUser==null){
			request.setAttribute("msg", "亲!您还没有登录");
			return "msg";
		}
		order.setUid(existUser.getUid());
		order.setUser(existUser);
		//3.设置订单项集合		
		for(CartItem cartItem : cart.getCartItems()){
			//订单项的信息是从购物车中获得的
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);
		}
		
		//4.执行数据库的插入操作
		orderService.save(order);
		
		for(CartItem cartItem : cart.getCartItems()){
			//订单项的信息是从购物车中获得的
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());			
			//插入数据到orderItem中
			orderItem.setOid(order.getOid());
			orderItem.setPid(cartItem.getProduct().getPid());
			orderItemService.insert(orderItem);
			
		}			
		//5. 清空购物车:
		cart.clearCart();		
		//6.页面需要回显到页面
		request.setAttribute("order", order);
		System.out.println("**************************");
		System.out.println(order.getOid());
		System.out.println(order.getTotal());
		System.out.println(order.getState());
		System.out.println("**************************");
		return "order";
	}
	
		
		
		/**
		 * 为订单付款:
		 * @param order
		 * @return
		 * @throws IOException
		 */
		@RequestMapping("/payOrder")
		public void payOrder(Order order,HttpServletRequest request,HttpServletResponse response) throws IOException {
			// 1.修改数据:
			Order currOrder = orderService.findByOid(order.getOid());
			currOrder.setAddr(order.getAddr());
			currOrder.setName(order.getName());
			currOrder.setPhone(order.getPhone());
			// 修改订单
			orderService.update(currOrder);
						
			// 2.完成付款:
			// 付款需要的参数:
			String p0_Cmd = "Buy"; // 业务类型:
			String p1_MerId = "10001126856";// 商户编号:
			String p2_Order = order.getOid().toString();// 订单编号:
			String p3_Amt = "0.01"; // 付款金额:
			String p4_Cur = "CNY"; // 交易币种:
			String p5_Pid = ""; // 商品名称:
			String p6_Pcat = ""; // 商品种类:
			String p7_Pdesc = ""; // 商品描述:
			String p8_Url = "http://localhost/FlowerShop/orderController/callBack.action"; // 商户接收支付成功数据的地址:
			String p9_SAF = ""; // 送货地址:
			String pa_MP = ""; // 商户扩展信息:
			//String pd_FrpId = "ABC-NET-B2C";// 支付通道编码:
			String pd_FrpId = request.getParameter("pd_FrpId");
			System.out.println("***************");
			System.out.println(pd_FrpId);
			System.out.println("***************");
			String pr_NeedResponse = "1"; // 应答机制:
			String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
			String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
					p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
					pd_FrpId, pr_NeedResponse, keyValue); // hmac
			// 向易宝发送请求:
			StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
			sb.append("p0_Cmd=").append(p0_Cmd).append("&");
			sb.append("p1_MerId=").append(p1_MerId).append("&");
			sb.append("p2_Order=").append(p2_Order).append("&");
			sb.append("p3_Amt=").append(p3_Amt).append("&");
			sb.append("p4_Cur=").append(p4_Cur).append("&");
			sb.append("p5_Pid=").append(p5_Pid).append("&");
			sb.append("p6_Pcat=").append(p6_Pcat).append("&");
			sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
			sb.append("p8_Url=").append(p8_Url).append("&");
			sb.append("p9_SAF=").append(p9_SAF).append("&");
			sb.append("pa_MP=").append(pa_MP).append("&");
			sb.append("pd_FrpId=").append(pd_FrpId).append("&");
			sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
			sb.append("hmac=").append(hmac);
			
			// 重定向:向易宝出发:
			response.sendRedirect(sb.toString());
		}
		
		
		/**
		 *  付款成功后跳转回来的路径:
		 * @return
		 */
		@RequestMapping("/callBack")
		public String callBack(HttpServletRequest request){
			// 修改订单的状态:
			
			String r6_Order = request.getParameter("r6_Order");
			String r3_Amt = request.getParameter("r3_Amt");
			
			Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
			// 修改订单状态为2:已经付款:
			currOrder.setState(2);
			orderService.update(currOrder);
			request.setAttribute("msg", "支付成功!订单编号为: "+r6_Order +" 付款金额为: "+r3_Amt);
			return "msg";
		}
		
		
		// 根据订单id查询订单:
		@RequestMapping("/findByOid")
		public String findByOid(Order order,HttpServletRequest request,Model model) {
			//1.设置订单关联用户		
			User existUser = (User) request.getSession().getAttribute("existUser");
			if(existUser==null){
				request.setAttribute("msg", "亲!您还没有登录");
				return "msg";
			}
			order.setUid(existUser.getUid());
			order.setUser(existUser);
			
			List<OrderSet> orderList = orderService.findByOrderid(order.getOid());
			//2.根据订单项去查询该订单对应的商品信息
			model.addAttribute("orderList", orderList);
			
			return "order2";
		}

		
		/**
		 * 查询我的订单:
		 * @param request
		 * @return
		 */
		@RequestMapping("/findByUid")
		public String findByUid(HttpServletRequest request,int page) {
			// 从session中获取登陆的用户
			User existUser = (User) request.getSession().getAttribute("existUser");
			// 获得登陆用户的id
			Integer uid = existUser.getUid();
			if(uid==null){
				request.setAttribute("msg", "亲!请您重新登录");
				return "msg";
			}
			// 根据登陆用户的id分页查询订单:		
			PageBean<Order> pagebean = orderService.findByUid(uid,page);			
			request.setAttribute("pagebean", pagebean);
			return "orderList";
		}
		
		
		/**
		 *  后台管理员修改订单的状态:   --》确认收货
		 * @return
		 */
		@RequestMapping("/updateState")
		public String updateState(Order order){
			Order currOrder = orderService.findByOid(order.getOid());
			currOrder.setState(4);
			orderService.update(currOrder);
			return "redirect:/orderController/findByUid?page=1";
		}
}
