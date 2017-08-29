package com.lf.ssm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * 
 * @author LF学习
 * <p>文件上传类</p>
 * 拿到本地文件数据然后展示到页面上
 */
public class FileUploadingUtil {


	
	/**
	 * 解析excel工具类
	 * @author fan
	 * @param excelPath 文件路径
	 * @return List<HashMap<String, Object>> 集合
	 */
	public static List<HashMap<String, Object>> readExcel(String excelPath){

		//声明一个集合，存储解析完成的所有数据
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		Workbook book = null;
		Sheet sheet = null;
		InputStream is = null;
		//导入模板文件
//		String file = "F:\\test_01.xls";
		try {
			//创建文件输入流
			 is = new FileInputStream(excelPath);
			//获取excel的文件对象
			 book = Workbook.getWorkbook(is);
			 sheet = book.getSheet(0);
			//获取行
			int rows = sheet.getRows();
			//获取列
			int cols = sheet.getColumns();
			
			//循环迭代内容
			for(int i=0;i<rows-1;i++){
				//从第二行开始读取
				Cell[] cells = sheet.getRow(i+1);
				String title = cells[0].getContents();
				String desc = cells[1].getContents();
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("title", title);
				map.put("desc", desc);
				list.add(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(book != null){
				book.close();
			}
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//解析excel中的数据
		
		//将解析解析好的数据存储到容器中（集合，数组，）
		
		//返回到页面中进行展示，同步到数据库中
		
		return list;
		
	}





}
