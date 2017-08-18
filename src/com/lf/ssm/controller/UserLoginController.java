package com.lf.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lf.ssm.service.impl.UserLoginServiceImpl;

/**
 * 
 * @author LF学习
 * <p>用户登录</p>
 */
@Controller
public class UserLoginController {
			@Autowired
	        private UserLoginServiceImpl userLoginServiceImpl;
	
			@Autowired
			private HttpServletRequest request;
			
			@Autowired
			private HttpServletResponse response;
	
			
			/**
			 * 登录验证
			 * @ModelAndView
			 */
			@RequestMapping("/login")
			public ModelAndView login(){
				String username=(request.getParameter("username")==null||request.getParameter("username").trim().equals(""))?null:request.getParameter("username");
				String password=(request.getParameter("password")==null||request.getParameter("password").trim().equals(""))?null:request.getParameter("password");
				ModelAndView  modelAndView = new ModelAndView();
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("USERNAME", username);
				params.put("PASSWORD", password);
				List<Map<String, Object>> userList = this.userLoginServiceImpl.userLogin(params);
				System.out.println("userList-->"+userList);
				if(userList.size()>0){
					 if(username == null && password == null){
						 modelAndView.addObject("loginFlag", "用户名和密码不能为空！");
						 modelAndView.setViewName("login");
					 }else{
						 modelAndView.addObject("loginFlag", "登录成功");
						 modelAndView.setViewName("main");
					 }
				 }else{
					  if(username == null && password!=null){
						modelAndView.addObject("loginFlag", "用户名不能为空，请输入用户名！");
						modelAndView.setViewName("login");
					}else if(password == null && username!=null){
						modelAndView.addObject("loginFlag", "密码不能为空，请输入密码！");
						modelAndView.setViewName("login");
					}else{
						modelAndView.addObject("loginFlag", "用户名或密码错误，请重新输入");
						modelAndView.setViewName("login");
					}
					
				}
				return modelAndView;
			}
			
			@RequestMapping("/toLogin")
			public ModelAndView toLogin(){
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("login");
				return modelAndView;
			}
}
