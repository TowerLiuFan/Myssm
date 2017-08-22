package com.lf.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.struts2.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lf.ssm.service.impl.UserLoginServiceImpl;
import com.lf.ssm.util.FileUploadingUtil;

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
			 * 用户登录
			 * @ModelAndView
			 */
			@RequestMapping("/login")
			public ModelAndView login(HttpSession Session){
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
						 Session.setAttribute("username", username);
						 modelAndView.addObject("loginFlag", "登录成功,");
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
			
			/**
			 * 从首页到登录页面
			 * @ModelAndView
			 */
			@RequestMapping("/toLogin")
			public ModelAndView toLogin(){
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("login");
				return modelAndView;
			}
			
			
			/**
			 * 主页到图片抓取页面的跳转
			 * @ModelAndView
			 */
			@RequestMapping("/searchDown")
			public ModelAndView searchDown(){
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("util/search");
				return modelAndView;
		 }
			
			/**
			 * 抓取图片回到原本页面
			 * @ModelAndView
			 */
			@RequestMapping("/search")
			public ModelAndView search(){
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("util/search");
				return modelAndView;
			}
			
			/**
			 * 主页到文件上传页面的跳转
			 * @ModelAndView
			 */
			@RequestMapping("/upLoading")
			public ModelAndView upLoading(){
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("util/upload");
				return modelAndView;
		 }
			
			/**
			 * 上传批量数据
			 * @throws JSONException 
			 * @throws IOException 
			 * @ModelAndView
			 */
			@RequestMapping("/dataUpLoading")
			@ResponseBody
			public List<HashMap<String, Object>>  dataUpLoading() throws JSONException, IOException{
				List<HashMap<String, Object>> list = FileUploadingUtil.readExcel("F:\\test_01.xls");
				return list;
		 }
			
		  
			
			
}










