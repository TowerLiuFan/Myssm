<%@page import="org.apache.struts2.json.JSONUtil"%>
<%@ page language="java" import="java.util.*,com.lf.ssm.util.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<HashMap<String, Object>> list = FileUploadingUtil.readExcel("F:\\test_01.xls");
	out.println(JSONUtil.serialize(list));

%>