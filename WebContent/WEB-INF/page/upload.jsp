<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>单个文件上传</h3>
		<form action="uploadFile" method="post" enctype="multipart/form-data">
		   <input type="file" name="uploadFile">
		   <input type="submit" value="单个文件上传">
		</form>
		</br></br>
		<h3>多个文件上传</h3>
		<form action="moreUploadFile" method="post" enctype="multipart/form-data">
		   <input type="file" name="moreUploadFile">
		   <input type="file" name="moreUploadFile">
		   <input type="file" name="moreUploadFile">
		   <input type="submit" value="多个文件上传">
		</form>
		<h4>刚才上传的图片</h4>
		 <table>
	  	<tr>
	  		<c:forEach items = "${uploadMap}" var="item">
	  			<td>
	  				<a href="downloadFile?fileName=${item.value}" >${item.key}</a>　: 
	  				<img src = "<%=basePath%>upload/${item.value}" width = "200" height="200">	
	  			</td>	  			
	  		</c:forEach>
	  	</tr>	  
	  </table>   
</body>
</html>














