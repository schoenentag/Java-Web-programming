<%@page import="co.micol.prj.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 이름 수정</title>
<script>
function validationForm(){
	if(frm.employeeID.value == ""){ /* 값입력이 안되었을 경우... */
		alert("사원번호 입력");
	    return;
	}
	frm.submit(); /* 값입력되어있으면 submit(전송 클릭한것과 같음) */
}

</script>
</head>
<body>
<% EmpVO emp = (EmpVO) request.getAttribute("emp"); %>
<form name="frm" action="EmpUpdateServ" method="post">
    사원번호 <input name="employeeID" value="<%= emp.getEmployeeID()%>">
    이름 <input name="firstName" value="<%= emp.getFirstName()%>">
    
    <button type="button" onclick="validationForm()"> 이름수정</button>


</form>

</body>
</html>