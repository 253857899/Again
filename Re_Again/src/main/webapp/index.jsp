<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<style>
.left{
	width:15%;height: 500px;
}
.right{
width:85%;height: 500px;position: absolute;left: 15%;top:0;
}
</style>
<body>
<a href="User/outlogin">注销</a> <br>
<s:hasPermission name="add"> 尊敬的VIP8,牛批666 </s:hasPermission> <br>
<script type="text/javascript">
function ok(o){
	if(o.contentWindow.location.href.indexOf("login")>0){
		open("login.html","_self");
	}
	
}

</script>
<div class="left">
<a href="Type/index" target="right">type</a>
</div>


<div class="right">
<iframe name="right" width="300" height="300" src="Type/index" onload="ok(this);"></iframe>
</div>
</body>
</html>