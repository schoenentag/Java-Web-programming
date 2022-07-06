<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서목록(JSTL대체)</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<h4>부서목록</h4>
<a href="DeptInsert">부서등록</a>
<table border="1">
    <tr><td>부서번호</td><td>부서명</td></tr>

<c:forEach items="${list}" var="dept">
	<tr>
	<td>${ dept.departmentId }</td>
	<td><a href="DeptUpdate?departmentId=${ dept.departmentId }"> ${ dept.departmentName }</a></td>
	</tr>

</c:forEach>
</table>
</body>
</html>