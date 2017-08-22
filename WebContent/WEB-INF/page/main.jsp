<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type='text/css'>    
		.clear { zoom:1; }
		.clear:after { visibility:hidden; display:block; font-size:0; content:"1"; clear:both; height:0; }
		.main { width:1200px; }
		.btn span { width:100px; text-align:center;  background:#f00; cursor:pointer; margin:0 5px; display:block; float:left; }
		.con { display:none; border:#033 1px solid; height:600px; width:1000px; }
        #search{
        		display:inline-block;width:32px;height:32px;
        		background-image:url("images/hand.png");
        		position:0px 0px;background-repeat:no-repeat; 
        		margin-right:20px;
        }
        #search:HOVER{
                display:inline-block;width:32px;height:32px;
        		background-image:url("images/hand_.png");
        		position:0px 0px;background-repeat:no-repeat; 
        		margin-right:20px;
        }
        #upload{
                display:inline-block;width:32px;height:32px;
        		background-image:url("images/upload_.png");
        		position:0px 0px;background-repeat:no-repeat;
        }
        #upload:HOVER{
                display:inline-block;width:32px;height:32px;
        		background-image:url("images/upload.png");
        		position:0px 0px;background-repeat:no-repeat;
        }
        </style>
	    <script src = "js/jquery-1.9.1.min.js"></script>
</head>
<body>
	  <div>
	      <h2>用户功能主页</h2>
	  </div>
	  <a id="search" href="searchDown"></a>
	  <a id="upload" href="upLoading"></a>
	  <div  class="main">
	      <div class="btn clear">
	          <span>用户列表</span>
	          <span>用户编辑</span>
	      </div>
	      
	      <div class="con">
	          <h2>用户列表区</h2>
	      </div>
	      
	      <div class="con">
	          <h2>用户编辑区</h2>
	      </div>
	  </div>	
	 
</body>
<script type="text/javascript">
		//eq表示返回一个jQuery对象
		$(".con").eq(0).show();
		$(".btn span").click(function(){
		  var num =$(".btn span").index(this);
		 //siblings表示取得一个包含匹配的元素集合中每一个元素的所有唯一同辈元素的元素集合
		  $('.con').eq(num).css({display:'block'}).siblings('.con').css({display:'none'});
		}); 

</script>
</html>












