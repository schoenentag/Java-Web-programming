<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="co.micol.prj.emp.JobsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.micol.prj.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 이름 수정</title>
<style>
form > label {
display : inline-block;
width: 15%;
background-color:lightgray;
text-align:center;
}
</style>
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
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<% EmpVO vo = (EmpVO) request.getAttribute("emp"); %>
<form  name="frm" action="DeptUpdate" id="empform" method="post" onsubmit="return validateForm()">
	<label for="employeeID">사원번호*</label>
	<input type="text" name="employeeID" readonly="readonly" value="<%=vo.getEmployeeID()%>"><br>
	<label for="firstName">이름</label>
	<input type="text" name="firstName" value="<%=vo.getFirstName()%>"><br>
	<label for="lastName">성*</label>
	<input type="text" name="lastName" value="<%=vo.getLastName()%>"><br>
	<label for="email">이메일*</label>
	<input type="text" name="email" value="<%=vo.getEmail()%>"><br>
	<label for="phone">핸드폰 번호</label>
	<input type="text" name ="phone" value="<%=vo.getPhone()%>"><br>
	<label for="hireDate">입사일*</label>
	<input type="date" name="hireDate" value="<%=vo.getHireDate().substring(0,10)%>"><br>
	
	<label for="jobId">직무*</label>
	<select  name="jobId">
	 <!-- FK키// 직무는 선택하도록 for문 돌림 --> <!-- request.setAttribute("jobs")의 값을 가져옴 -->
	<% ArrayList<JobsVO> list = (ArrayList<JobsVO>)request.getAttribute("jobs");
	for(JobsVO jobs : list) { %>
	<option value="<%=jobs.getJobId() %>" <%-- <% if(jobs.getJobId().equals(vo.getJOB_ID())){ %>selected="selected"<% } %> --%>>
	<%=jobs.getJobTitle()%> 
	<% } %>
	</select><br>
	
	<!-- radio for문 -->
	<label for="departmentId">부서번호</label>
	<% ArrayList<DeptVO> dlist = (ArrayList<DeptVO>)request.getAttribute("depts");
	for(DeptVO depts : dlist){ %>
	<input type="radio" name="departmentId" value="<%=depts.getDepartmentId()%>" 
	<% if(depts.getDepartmentId().equals(vo.getDepartmentsId())) { %>checked="checked"<% } %> >
	<%= depts.getDepartmentName() %>
	<% }%><br>
	
	<label for="salary">연봉</label>
	<input type="text" name ="salary"  value="<%=vo.getSalary()%>"><br>
	<input type="submit" id="update" value="수정" ><br>
	<button type="button" onclick="empDelete()">삭제</button>
</form>
<script>
    function empDelete(){
    	location.href="EmpDeleteServ?employeeID=<%=vo.getEmployeeID()%>";
    }
    document.getElementsByName("jobId")[0].value = "<%=vo.getJOB_ID()%>";
    document.querySelector("[name=departmentId][value='<%=vo.getDepartmentsId()%>']").checked=true;

    </script>

</body>
</html>