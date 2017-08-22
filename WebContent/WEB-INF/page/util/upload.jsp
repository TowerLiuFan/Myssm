<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
    *{margin:0;padding:0;}
    body{font-size: 12px;font-family: "微软雅黑";background:lightgray;}
    .import{width:800px;margin:30px auto;}
    .i-title{font-size:20px;}
    .import .i-btn{width:140px;height:36px;background: #188eee;color:#fff;font-size:14px;
                   display:inline-block;text-align: center;line-height: 36px;text-decoration: none;
                   border-radius:8px;margin:50px 0;}
    .import .i-clear{width:140px;height:36px;background: #188eee;color:#fff;font-size:14px;
                   display:inline-block;text-align: center;line-height: 36px;text-decoration: none;
                   border-radius:8px;margin:50px 0 50px 15px;}  
    .import .i-btn:hover{background:#1080da;}
    .import .i-clear:hover{background:#1080da;} 
    .i-con{border-top:1px solid #D1E0EF;border-bottom: 1px solid #D1E0EF;}
    .i-con .i-list{margin:20px 0;padding-left:10px;}
    .i-con .i-list:hover{background:gray;}
    .i-con .i-list p{line-height: 46px;font-size:16px;}
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
		<div class="import">
		    <h1 class="i-title">java开发大数据批量导入系统【后台管理核心技术】</h1>
		    <a href="#" class="i-btn">上传批量数据</a>
		    <a href="#" class="i-clear">清空数据</a>
		    <a id="back" href="toMain"></a>
		    <div class="i-con" id="i-con-info"></div>
		</div>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src=sg/tz_util.js></script>
<script type="text/javascript" src="sg/sg.js"></script>
<script type="text/javascript">
   	$(function(){
   		//点击按钮
   		$(".i-btn").click(function(){
   			$.ajax({
   			 type: "post",
   			 beforeSend:function(data){
   				 //数据解析中
    				loading("数据正在解析中... "); 
   			 },
   			 url:"dataUpLoading",
   			 success:function(data){
//        	     var jdata = eval("("+data+")");
   				 var html = "";
   				 for(var i=0;i<data.length;i++){
   					html += "<div class='i-list'>"+
  		                    "<p>第"+(i+1)+"课名称："+data[i].title+"</p>"+
  		          			"<p>第"+(i+1)+"课描述："+data[i].desc+"</p>"+
  		       				"</div>";
   				 };
   				 $("#i-con-info").html(html);
   				 loading("数据解析成功！",2);
   			 }
   			});
   		})
   		$(function(){
   			$(".i-clear").click(function(){
   				var content = $("#i-con-info").html(); 
   				if(content == null || content == ""){
   					loading("页面无数据！",2);
   				}else{
   					$("#i-con-info").html("");
   					loading("清空成功",2);
   				}
   			})
   		})
   	})

</script>		
		
		
</body>
</html>














