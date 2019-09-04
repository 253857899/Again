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

<script type="text/javascript">
function del(id){
	if(confirm("删除????"))
	open("delete?id="+id,"_self");
}
</script>


<form action="index" method="post">
	<input name="txt">
	<button type="submit">查询</button>
	<button type="button" onclick="window.open('add','_self');">新增</button>
</form> 

<table>
<tr><td>编号</td><td>名称</td><td>状态</td><td>书名</td><td>修改</td><td>删除</td></tr>
<c:forEach items="${list}" var="row" varStatus="v">
<tr><td>${row.id}</td><td>${row.name}</td>
<td>${row.status_name}</td>
<td>${row.bookname}</td>
<td><a href="add?id=${row.id}">修改</a></td>
<td><a href="javascript:del(${row.id})">删除</a></td></tr>
</c:forEach>
</table>
</body>
</html>