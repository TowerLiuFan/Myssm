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
	
			@RequestMapping("/login")
			public ModelAndView login(){
				
				String username = request.getParameter("username").trim();
				String password = request.getParameter("password").trim();
				ModelAndView  modelAndView = new ModelAndView();
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("USERNAME", username);
				params.put("PASSWORD", password);
				List<Map<String, Object>> userList = this.userLoginServiceImpl.userLogin(params);
				System.out.println("userList-->"+userList);
				if(userList!=null || !"".equals(userList)){
					modelAndView.addObject("flagLogin", "成功");
					modelAndView.setViewName("main");
				}
					
					
				
				
				
				
				return modelAndView;
				 
			}
}
