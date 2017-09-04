<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{margin:0px;padding:0;}
/* 	body{background-image:url("images/5.jpg");background-size:1200px 450px;background-repeat:no-repeat;} */
    #login{width:300px;height:280px;top:200px;left:900px;border: 1px solid gray;position:absolute;}
	#login{background:white;border-radius:10px;opacity:0.7;z-index:10;}
	#login_bg{
	   	    height:580px;width:1280px;
    		background-image:url("images/bizhi2.jpg");
    		background-repeat:no-repeat;
    		margin:25px auto;
    		background-size:1280px 580px;
    		position: relative;
	}
	#username{display:block;position:absolute;top:100px;left:23px;outline:none;}
	#password{display:block;position:absolute;top:160px;left:23px;}
	#submit{
			display:block;width:32px;height:32px;
			position:absolute;top:232px;left:210px;
			background-image:url("images/submit_.png");
			background-repeat:no-repeat;
			background-position:0px 0px;
			background-color:white;
			border:0;
			outline-width:0;
	  }
    #submit:HOVER{cursor:pointer;background-image:url("images/submit.png");}
    #message{color:red;margin-top:10px;font-family:"微软雅黑";}
    #user{
    		display:inline-block;width:32px;height:32px;
    		background-image:url("images/user.png");
    		background-position:0px 0px;
    		position:absolute;top:0px; left:0px;
         }
    #pwd{
            display:inline-block;width:32px;height:32px;
    		background-image:url("images/pwd.png");
    		background-position:0px 0px;
    		position:absolute;top:0px; left:0px;
        }
</style>
<script type="text/javascript">
       //在3秒后隐藏提示信息
       setInterval(function(){
    	   document.getElementById("message").style.display="none";
       },2000);
</script>
</head>
<body style="background:gray";>
<embed src="bgm/bgm.mp3" loop="true" hidden="true" autoplay="true"></embed>
		<div id="login_bg"></div>
		<div id="login">
		<h3 align="center" style="height:40px;background:#1A8ED9;line-height:40px;border-radius:10px 10px 0px 0px;">用户登录</h3>
		<form action="login" method = "post">
				<div id="username"><a id="user"></a><input type="text" name="username" value="请输入您的用户" style="height:27px;width:185px;margin-left:40px;" onfocus="javascript:if(this.value=='请输入您的用户')this.value='';"/></div>
				<div id="password"><a id="pwd"></a><input type="password" name="password" style="height:27px;width:185px;margin-left:40px;"placeholder="请输入您的密码" /></div>
				<input id="submit" type="submit" value="" /> 
				<div id="message" align="center">${loginFlag}</div>
		</form>
		</div>
</body>
</html>