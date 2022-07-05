<%@page import="co.micol.prj.dept.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
    function validationForm(){
    	if(frm.departmentId.value==""){ /* 값입력이 안되었을 경우... */
    		alert("부서번호 입력");
    	    return;
    	}
    	frm.submit(); // /* 값입력되어있으면 submit(전송 클릭한것과 같음) */
    }
</script>
</head>
<body>
<% DeptVO dept= (DeptVO) request.getAttribute("dept"); %>
	<form name="frm" action="DeptUpdate" method="post"><!-- action =서블릿주소 -->
		부서번호<input name="departmentId" value="<%= dept.getDepartmentId() %>">
		부서명<input name="departmentName" value="<%= dept.getDepartmentName() %>">
		
		<button type="button" onclick="validationForm()">부서수정</button>
		

	</form>

</body>
</html>