<%@ page language="java" import="java.util.*,com.lf.ssm.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量采集系统</title>
<style type="text/css">
    *{margin:0;padding:0;}
    body{background: url("images/search/bg.jpg");background-size:cover;font-size:12px;font-family:"微软雅黑";color:#666;}
    .search{width:600px;height:100px;margin:60px auto;}
    .search h1{text-align: center;font-weight: 300;font-size: 22px;color:#fff;}
    .search .s-box{margin-top:20px;}
    .search .s-box .s-txt{width:480px;height:36px;border: none;padding-left:10px;outline:none;border-radius:
    					  8px 0 0 8px;}
    .search .s-box .s-btn{width:110px;height:36px;background:#3CBD38;border:none;outline:none;cursor:pointer;color:
    			          #fff;border-radius:0 8px 8px 0;}
    .search .s-box .s-btn:hover{background:#329F2F}
    .files{width:1000px;margin:0 auto;}
    .files ul li{width:132px;background:#fff;padding:5px;float:left;margin:12px;position:relative;}
    .files ul li:hover{background:#f1f1f1;}
    .files ul li p{line-height: 20px;text-align: center;}
    .f-close{width:30px;height:30px;display:block;background:url("images/search/tz_image_box.png");background-position:
    			-40px 0px;position:absolute;right:-12px;top:-12px;display:none; }
    .files ul li:hover .f-close{display: block;}
    #back{
            display:inline-block;width:32px;height:32px;
	  		background-image:url("images/back_.png");
	  		position:0px 0px;background-repeat:no-repeat; 
	  		position:absolute;top:15px;right:20px;
     }
     #back:HOVER{
            display:inline-block;width:32px;height:32px;
	  		background-image:url("images/back.png");
	  		position:0px 0px;background-repeat:no-repeat; 
     }   		
</style>
<link type="text/css" rel="stylesheet" href="sg/css/sg.css"></link>
</head>
<body>
<%
     String url  = request.getParameter("url");
	 List<HashMap<String, Object>> list = null;
	 String encoding = "gbk";
	 if(null != url){
		 list = DataDownUtil.findimages(url, encoding);
		 pageContext.setAttribute("list", list);  //存储在作用域中

	 }
%>
			<form action="search" method="post">
			<div class="search">
		    	<h1>Java开发批量采集系统</h1>
		    	<div class="s-box">
		    		<input type="text" class="s-txt" name ="url" placeholder="请输入需要下载的地址" /><input type="submit" value="开始下载" class="s-btn"/>
		    	    <a id="back" href="toMain"></a>
		    	</div>
			</div>
			</form>
			<div class="files">
				<ul>
				<c:forEach items="${list}" var="imglist">
					<li class="i-pare">
						<a href="#"><img src="${imglist.src}" alt="${imglist.title}" width="132" height="132" class="tzImgbox" /></a>
						<p>picture</p>
						<p>${imglist.title}</p>
						<a href="#" class="f-close" onclick="del(this);"></a>
					</li>
				</c:forEach>
				</ul>
			</div>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="sg/sg.js"></script>
<script type="text/javascript" src="sg/tz_util.js"></script>
<script type="text/javascript">
		loading("数据正在加载中...",2);
		$(".tzImgbox").tzImgbox();
		//删除
		function  del(obj){
			$.tzAlert({content:"您确定要删除吗?", callback:function(ok){
				 if(ok){
					  $(obj).parents(".i-pare").fadeOut(1000,function(){
						  $(this).remove();
					  });
				 }
			}});
		}
 		
	
</script>
	

</body>
</html>