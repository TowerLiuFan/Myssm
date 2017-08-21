package com.lf.ssm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author LF学习
 * <p>网站图片抓取类</p>
 */
public class DataDownUtil {
       


	public  static String getHtml(String url, String encoding){
		StringBuffer sb = new StringBuffer();
		InputStreamReader isr = null;
		URLConnection uc = null;
		BufferedReader br = null;
		try {
			//简历网络连接
			URL urlobj = new URL(url);
			//打开网络连接
		    uc = urlobj.openConnection();
			//简历文件写入流
		    isr = new InputStreamReader(uc.getInputStream(),encoding);
			//建立文件缓冲写入流
		    br = new BufferedReader(isr);
			String temp = null;
			while((temp = br.readLine()) !=null){
				sb.append(temp+"\n"); //一边读一边写
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("网络不给力，请检查网络设置");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("网络链接打开失败，请稍后重试 ！");
		}finally{
			if(isr !=null){
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
public static List<HashMap<String, Object>> findimages(String url,String encoding){
	List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
	String html = getHtml(url, encoding);
	Document document = Jsoup.parse(html);
	HashMap<String, Object> map = null;
	//获取源代码中所有的图片标签
	Elements elements = document.getElementsByTag("img");
	for(Element ele : elements){
		 map = new HashMap<String, Object>();
		//解析图片url地址
		String src = ele.attr("src");
		String title = ele.attr("title");
		//包含http开头并且图片是jpg结尾的
		if(src.startsWith("http") && src.indexOf("jpg") != -1){
//			System.out.println("地址"+src);
//			System.out.println("标题"+title);
			map.put("src", src);
			map.put("title",title);
			list.add(map);
		}
	}
	return list;
}	
	
	
	

	public static void main(String[] args) {
			
		String  url = "http://tech.qq.com/";
		String encoding = "gbk";
		
		//1.根据网址 和 页面 编码集 来获取网页的源代码
		String html = getHtml(url, encoding);
//		System.out.println(html);
		
		//2.解析源代码 找到图片标签URL地址
		Document document = Jsoup.parse(html);
		HashMap<String, Object> map = null;
		//获取源代码中所有的图片标签
		Elements elements = document.getElementsByTag("img");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		for(Element ele : elements){
			 map = new HashMap<String, Object>();
			//解析图片url地址
			String src = ele.attr("src");
			String title = ele.attr("title");
			//包含http开头并且图片是jpg结尾的
			if(src.startsWith("http") && 	src.indexOf("jpg") != -1){
//				System.out.println("地址"+src);
//				System.out.println("标题"+title);
				map.put("src", src);
				map.put("title",title);
				list.add(map);
			}
		}
		//3.组装数据到集合中，返回到页面中进行展示
		System.out.println(list);
	}

				
}
