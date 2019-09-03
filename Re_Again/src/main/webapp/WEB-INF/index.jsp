<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.left{
	width: 15%;  height: 500px; 
}
.right{
	width: 85%;  height: 500px;
}
</style>
<body>
<a href="User/outlogin">注销</a>

<div class="left">
<a href="Book/index" target="right">book</a><br>
<a href="Type/index" target="right">type</a>
</div>

<div class="right">
<iframe name="right"  ></iframe>
</div>
</body>
</html>