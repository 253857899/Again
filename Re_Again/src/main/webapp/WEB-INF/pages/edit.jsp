<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<c:if test="${param.id==null}">
<form action="insert" method="post">
<input name="name">
<input name="status">
<input type="submit" value="新增确定!">
</form>
</c:if>
<c:if test="${param.id!=null}">
<form action="update" method="post">
<input type="hidden" name="id" value="${id}">
<input name="name">
<input name="status">
<input type="submit" value="修改确定!">
</form>
</c:if>
</body>
</html>