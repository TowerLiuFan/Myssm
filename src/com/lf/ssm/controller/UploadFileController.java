package com.lf.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
			public String uploadFile(MultipartFile uploadFile, HttpServletRequest request){
				//将上传的文件保存到某个目录下面
//				String rootPath = request.getServletContext().getRealPath("upload");
				//1.得到某个目录的绝对路径(所有上传的文件都保存到这个目录中)
				String rootPath = "F:\\upload";
				if(uploadFile!=null){
					//获取上传文件的名称
					String  fileName = uploadFile.getOriginalFilename();
					//获取上传文件的后缀
					String suffix = fileName.substring(fileName.lastIndexOf("."));
					//为了避免重复，给上传的文件重新指定一个名称
					String tempFileName_ = UUID.randomUUID().toString()+suffix;
					String tempFileName = tempFileName_.replaceAll("-","");
					//通过指定的的路径创建一个新的实例
					File tempFile = new File(rootPath);
					if(!tempFile.exists()){
						//如果不存在，则在该目录下创建一个文件夹
						tempFile.mkdir();
					}
					File file = new File(rootPath+"\\"+tempFileName);
					System.out.println("file-------->"+file);
					try{
					  //将上传的文件写入指定路径
						uploadFile.transferTo(file);
					}catch(Exception e){
						 e.printStackTrace();
					}
				request.setAttribute("uploadFilePath", "upload/"+tempFileName);
				}
				return "upload";
				
			}
			
			/**
			 * 文件上传到页面(例如图片等)
			 * @param moreUploadFile
			 * @param request
			 * @return
			 */
			@RequestMapping
			public String moreUploadFile(@RequestParam MultipartFile[] moreUploadFile, HttpServletRequest request){
//			String rootPath = "F:\\upload";
			String rootPath = request.getSession().getServletContext().getRealPath("upload");
			Map<String,Object> mapPath = new HashMap<String,Object>();
			if(moreUploadFile!=null && moreUploadFile.length>0){
				 for(MultipartFile uploadFile: moreUploadFile){
					 if(uploadFile!=null){
					  String fileName = uploadFile.getOriginalFilename();
					  String suffix = fileName.substring(fileName.indexOf("."));
					  String tempFileName_ = UUID.randomUUID().toString()+suffix;
					  String tempFileName =  tempFileName_.replaceAll("-", "");
					  File fileTemp = new File(rootPath);
						if(!fileTemp.exists()){
							fileTemp.mkdir();
						}
						File file = new File(rootPath+"\\"+tempFileName);
						try {
							//讲上传的文件写入指定路径
							uploadFile.transferTo(file);
						} catch (Exception e) {
			 				e.printStackTrace();
						}
						mapPath.put(fileName, tempFileName);
						System.out.println("mapPath---------->"+mapPath);
					 }
				 }
				 request.setAttribute("uploadMap", mapPath);
			}
			     return "upload";	
		}
			
			@RequestMapping("/downloadFile")
			public void downloadFile(String fileName,
					HttpServletRequest request,HttpServletResponse response){
				if(fileName!=null){
					String realPath = request.getSession().getServletContext().getRealPath("upload/");
					System.out.println("realPath------->"+realPath);
					System.out.println("fileName------->"+fileName);
					File file = new File(realPath,fileName);
					OutputStream out = null;
					if(file.exists()){
						response.setContentType("application/force-download"); //设置强制下载不打开
						response.setHeader("Content-Disposition", "attachment;filename="+fileName);//设置文件名
						try {
							out = response.getOutputStream();
							out.write(FileUtils.readFileToByteArray(file));
							out.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally{
							if(out!=null)
								try {
									out.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}						
					}			
				}			
			}

	
}





























