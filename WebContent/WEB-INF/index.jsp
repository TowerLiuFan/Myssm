<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{margin:0;padding:0}
 	body{background:#ABB7C4;}  
    #index{
    		height:580px;width:1280px;
    		background-image:url("images/world.png");
    		background-repeat:no-repeat;
    		margin:20px auto;
    		background-size:1280px 580px;
    		position: relative;
    	}
    #clock{
           z-index:10;font-size:30px;
    	   position:relative;top:30px;
    	   left:450px;display:inline-block;
    	   color:yellow;font-weight:800;
    	  }
    #toLogin{
        	 display:inline-block;width:140px;
	   		 height:25px;text-decoration:none;
	   		 position:absolute;top:100px;
	   		 left:1123px;font-size:20px;color:pink;
	   		 font-weight:900;font-family:"微软雅黑";
    	}
    #toLogin:HOVER{font-size:22px;font-weight:900;font-family:"微软雅黑"}	  	
</style>
<script type="text/javascript">
		
		var weekName = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
		
		var myDate;
		setInterval(function(){
			myDate = new Date();
			var week = weekName[myDate.getDay()];
			 clock.innerHTML = myDate.toLocaleString()+" "+week;
		}, 1000);
     
		 //文字颜色闪烁
		 setInterval(function(){
			var color="red|orange|yellow|green|blue|purple|pink"; 
			color = color.split("|");
			document.getElementById("toLogin").style.color = color[parseInt(Math.random() * color.length)];
		 },400); 
		  
</script>
</head>
<body>
	  <div id="index">
	      <div id="clock"></div>
	      <a id="toLogin" href="toLogin">进入登录页面</a>
	  </div>
<script>(function(T,h,i,n,k,P,a,g,e){g=function(){P=h.createElement(i);a=h.getElementsByTagName(i)[0];P.src=k;P.charset="utf-8";P.async=1;a.parentNode.insertBefore(P,a)};T["ThinkPageWeatherWidgetObject"]=n;T[n]||(T[n]=function(){(T[n].q=T[n].q||[]).push(arguments)});T[n].l=+new Date();if(T.attachEvent){T.attachEvent("onload",g)}else{T.addEventListener("load",g,false)}}(window,document,"script","tpwidget","//widget.seniverse.com/widget/chameleon.js"))</script>
<script>tpwidget("init", {
    "flavor": "bubble",
    "location": "WTTE97PU94T9",
    "geolocation": "disabled",
    "position": "top-left",
    "margin": "40px 100px",
    "language": "zh-chs",
    "unit": "c",
    "theme": "chameleon",
    "uid": "U157956339",
    "hash": "877671eaedadc3d1b0318963881380b2"
});
tpwidget("show");</script>
</body>
</html>








