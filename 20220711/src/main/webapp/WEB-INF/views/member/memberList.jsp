<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list }" var = 'm'>
 ${m.memberID } : ${m.memberName } : ${m.memberAuthor }<br>
</c:forEach> <!-- vo객체와 똑같은 이름으로... -->

</body>
</html>