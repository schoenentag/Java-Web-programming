<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<!-- http://localhost/ -->

<div class="topnav">
    <a <% if(request.getRequestURI().endsWith("boardList.jsp") ) {%>class ="active"<% }%> href="<%=request.getContextPath()%>/boardList">BOARD LIST</a> <!-- 절대경로 -->
    <a <% if(request.getRequestURI().endsWith("boardInsert.jsp") ) {%>class ="active"<% }%> href="<%=request.getContextPath()%>/boardInsert">BOARD INSERT</a>
</div>
</body>
</html>