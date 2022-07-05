<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="co.micol.prj.emp.JobsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>empInsert</title>
<head>
<style>
form > label {
display : inline-block;
width: 15%;
background-color:lightgray;
text-align:center;
}


</style>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
<script>

function validateForm(){
	if(window.document.frm.employeeID.value == ""){
		alert("사번을 입력하세요!");
		frm.employeeID.focus();
		return false;
	}
	if(window.document.frm.lastName.value == ""){
		alert("성을 입력하세요!");
		frm.lastName.focus();
		return false;
	}
	if(window.document.frm.email.value == ""){
		alert("이메일을 입력하세요!");
		frm.email.focus();
		return false;
	}
	/* 이메일 정규식 */
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(regExp.test(frm.email.value) == false){
		alert("이메일 형식에 맞게 작성하세요.");
		frm.email.focus();
		return false;
	}
	
	if(window.document.frm.hireDate.value == ""){
		alert("입사일을 입력하세요!");
		frm.hireDate.focus();
		return false;
	}
	if(window.document.frm.jobId.value == ""){
		alert("직무를 입력하세요!");
		frm.jobId.focus();
		return false;
	}
	
	return true;
}

</script>
</head>
<body>
	<h3>사원 등록</h3>
	<form  name="frm" action="empInsert" id="empform" method="post" onsubmit="return validateForm()">
	<label for="employeeID">사원번호*</label>
	<input type="text" name="employeeID" value=""><br>
	<label for="firstName">이름</label>
	<input type="text" name="firstName" value="anna"><br>
	<label for="lastName">성*</label>
	<input type="text" name="lastName" value="Lee"><br>
	<label for="email">이메일*</label>
	<input type="text" name="email" value="asdf@gmail.com"><br>
	<label for="phone">핸드폰 번호</label>
	<input type="text" name ="phone" value="010-1111-1234"><br>
	<label for="hireDate">입사일*</label>
	<input type="date" name="hireDate" value="2022-07-05"><br>
	<label for="jobId">직무*</label>
	<select  name="jobId">
	 <!-- FK키// 직무는 선택하도록 for문 돌림 --> <!-- request.setAttribute("jobs")의 값을 가져옴 -->
	<% ArrayList<JobsVO> list = (ArrayList<JobsVO>)request.getAttribute("jobs");
	for(JobsVO jobs : list) { %>
	<option value="<%=jobs.getJobId() %>"><%=jobs.getJobTitle()%> 
	<% } %>
	</select><br>
	<!-- radio for문 -->
	<label for="departmentId">부서번호</label>
	<% ArrayList<DeptVO> dlist = (ArrayList<DeptVO>)request.getAttribute("depts");
	for(DeptVO depts : dlist){ %>
	<input type="radio" name="departmentId" value="<%=depts.getDepartmentId()%>"><%= depts.getDepartmentName()%>
	<% }%><br>
	<label for="salary">연봉</label>
	<input type="text" name ="salary"  value=""><br>
	<input type="submit" id="insert" value="등록" ><br>
	</form>
</body>
</html>