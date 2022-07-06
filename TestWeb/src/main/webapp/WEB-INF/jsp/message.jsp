<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>message.jsp</title>
<style>
div{
background-color: #04AA6D;
font-size:30px;}
</style>
</head>
<body>
<script>
alert('<%= request.getAttribute("msg") %>')
location.href="EmpListServ"
</script>

</body>
</html>