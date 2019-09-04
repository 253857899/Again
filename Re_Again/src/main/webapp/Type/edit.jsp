<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<c:if test="${info==null}">
<form action="insert" method="post">
<input name="name" value="${info.name}">
<select name = "status" >
<c:forEach items="${statuses}" var="row" varStatus="v">
<option value="${v.index+1}">${row}</option>
</c:forEach>
</select>
<select name = "bookid" >
<c:forEach items="${booklist}" var="row" varStatus="v">
<option value="${v.index+1}">${row.name}</option>
</c:forEach>
</select>
<input type="submit" value="新增确定!">
</form>
</c:if>
<c:if test="${info!=null}">
<form action="update" method="post">
<input type="hidden" name="id" value="${id}">
<input name="name" value="${info.name}">
<select name = "status">
<c:forEach items="${statuses}" var="row" varStatus="v">
<option value="${v.index+1}" <c:if test="${info.status == v.index+1}">selected="selected"</c:if> >${row}</option>
</c:forEach>
</select>
<select name = "bookid" >
<c:forEach items="${booklist}" var="row" varStatus="v">
<option value="${v.index+1}" <c:if test="${info.bookid == v.index+1}">selected="selected"</c:if>>${row.name}</option>
</c:forEach>
</select>
<input type="submit" value="修改确定!">
</form>
</c:if>
</body>
</html>