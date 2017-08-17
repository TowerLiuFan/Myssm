<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{margin:0px;padding:0;}
	body{background:lightgray;}
    #login{width:300px;height:280px;top:200px;left:900px;border: 1px solid gray;position: absolute;}
	#login{background:white;border-radius:10px;}
	#username{display:block;position:absolute;top:120px;left:23px;}
	#password{display:block;position:absolute;top:160px;left:23px;}
	#submit{display:block;width:40px;height:32px;background:skyblue;position:absolute;top:232px;left:210px;}
    #submit{border:0px;border-radius:5px;}
    #submit:HOVER{cursor:pointer;background:#1A8ED9;}
    #message{color:red;margin-top: 10px;}
</style>
</head>
<body>
		<div id="login">
		<h3 align="center" style="height:40px;background:#1A8ED9;line-height:40px;border-radius:10px 10px 0px 0px;">用户登录</h3>
		<form action="login" method = "post">
				<div id="username">用户名：<input type="text" name="username" /></div>
				<div id="password">&nbsp;密码：<input type="password" name="password" /></div>
				<input id="submit" type="submit" value="登录" /> 
				<div id="message" align="center">${loginFlag}</div>
		</form>
		</div>
</body>
</html>