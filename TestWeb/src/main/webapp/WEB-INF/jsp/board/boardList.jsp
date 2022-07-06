<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<style>
table {
  border-collapse: collapse;
  width: 50%; 
  border: 1px solid #ddd; /* Add a grey border */
  font-size: 16px; 
}
table > thead{
color: white;
background-color: #04AA6D;
}
</style>
</head>
<body>
<br>
<table border="1">
<thead>
<tr><th>NO</th><th>TITLE</th><th>CONTENT</th><th>WRITER</th><th>R.D.T</th><th>HIT</th></tr>
</thead>
<tbody>
<jsp:include page="/WEB-INF/jsp/board/boardHeader.jsp"></jsp:include>
<c:forEach items="${list}" var="vo">
<tr>
<td>${ vo.getId() }</td>
<td>${ vo.getTitle() }</td>
<td>${ vo.getContent() }</td>
<td>${ vo.getWriter() }</td>
<td>${ vo. getRdt().substring(0,10) }</td>
<td>${ vo.getHit() }</td>
</tr>
</c:forEach>

</tbody>
</table>

</body>
</html>