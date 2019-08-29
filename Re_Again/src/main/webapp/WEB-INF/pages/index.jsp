<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="layui/layui.all.js"></script>
<script src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<title></title>
</head>
<body>

<form action="index" method="post">
<input name="name">
<input type="submit" value="开始战斗!">
</form>
<table>
<tr><td>编号</td><td>名称</td><td>状态</td></tr>
<c:forEach items="${typelist}" var="row" varStatus="v">
<tr><td>${row.id}</td><td>${row.name}</td><td>${row.status}</td></tr>
</c:forEach>
</table>
</body>
</html>