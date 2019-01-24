<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>向服务器发起请求</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
<h1>版本02</h1>
<%-- 
1通过表单发起请求
2通过链接发起请求
3通过Ajax发起请求
4通过JavaScript发起请求 location.href="";
--%>>
<hr>
<%--1通过表单发起请求--%>
	<form method="post" action="${pageContext.request.contextPath}/Stuservlet02?method=addStu">
		输入姓名：<input type="text" name="stuName"/><button>提交</button>
	</form>
<hr>
<%--1通过链接发起请求--%>
	<a href="${pageContext.request.contextPath}/Stuservlet02?method=delStu&stuId=001">删除学生</a>
<hr>
<%--1通过Ajax发起请求--%>
	<button id="btn01">用AJAX发起请求</button>
<hr>
<%--1通过javascript发起请求 location.href=""--%>	
	<button id="btn02">用javascript发起请求</button>
	<script type="text/javascript">
	//页面加载完毕
	//为id为btn的按钮绑定点击事件，通过点点击事件向服务器发起ajax请求
	$(function(){
		//页面加载完毕
		//为id为btn的按钮绑定点击事件，通过点点击事件向服务器发起ajax请求
		$("#btn01").click(function(){
			$.post("Stuservlet02", {"method":"updateStu","stuId":"s002"}, function(data){
				//在火狐浏览器控制台下打印服务端信息
				console.log(data);
				return;
			});
		});
		
		//为id为btn02的按钮绑定点击事件，通过点点击事件向服务器发起请求
		$("#btn02").click(function(){
			//通过点击事件向服务器发起请求，location.href=""
			location.href="Stuservlet02?method=findStu";
		});
	});
	</script>
</body>
</html>