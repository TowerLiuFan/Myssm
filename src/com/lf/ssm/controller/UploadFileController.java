package com.lf.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author LF学习
 * <p>用于处理文件上传的控制器</p>
 */
@Controller
public class UploadFileController {
				
			@RequestMapping("/toUpload")
			public ModelAndView toUpload(){
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("upload");
				return modelAndView;
			}
			
			/**
			 * 文件上传
			 * @param multipartFile
			 * @return
			 */
			@RequestMapping("/uploadFile")
			public String uploadFile(MultipartFile uploadFile){
				
				return "";
			}
	
	
	
}





























