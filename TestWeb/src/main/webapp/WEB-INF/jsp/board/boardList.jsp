<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>BOARD LIST</h4>
<table border="1">
<tr><td>NO</td><td>TITLE</td><td>CONTENT</td><td>WRITER</td><td>R.D.T</td><td>HIT</td></tr>

<%ArrayList(BoardVO) list = request.getAttribute("list");
for(BoardVO board : list) {%>
<tr>
<td><%=board.getId() %></td>
</tr>
<% } %>

</table>

</body>
</html>