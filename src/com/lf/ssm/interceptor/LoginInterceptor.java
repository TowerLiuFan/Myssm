package com.lf.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LF学习
 * <p>拦截器类</p>
 * 
 */
public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 在执行handler方法之前运行这个里面的方法，
	 * 常用于用户登录验证
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle");
		//需要先过滤匿名访问地址
		String url = request.getRequestURI();
		System.out.println("url------>"+url);
		if(url.indexOf("login")>=0){
			return true;
		}
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username != null){
			 return true;
		}else{
			System.out.println("之前没有登陆过");
			request.getRequestDispatcher("WEB-INF/page/login.jsp").forward(request, response);
		}
		return false;
	}
	/**
	 * 在执行handler方法之前，返回ModelAndView之前，
	 * 运行这个里面的代码，向页面提供一些共用的数据
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		    System.out.println("postHandle");
	}
	
	/**
	 * 在执行handler方法之后，运行里面的代码。
	 * 计算某个handler方法的的时间
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		 System.out.println("afterCompletion");
	}
	
	

	

}
