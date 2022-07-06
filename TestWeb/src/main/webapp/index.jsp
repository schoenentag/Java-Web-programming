<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%@include file="/WEB-INF/jsp/header.jsp" %> --%> <!-- 정적인 것은 가능 -->
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include> <!-- 동적인것 포함 -->
	<div align="center">
		<h1>Welcome to My Home</h1>
	</div>
</body>
</html>