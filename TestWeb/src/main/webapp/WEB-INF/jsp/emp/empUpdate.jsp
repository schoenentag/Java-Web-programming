<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="co.micol.prj.emp.JobsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.micol.prj.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 이름 수정(JSTL)</title>
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
<%-- <% EmpVO vo = (EmpVO) request.getAttribute("emp"); %> --%>

${emp}
<form  name="frm" action="EmpUpdateServ" id="empform" method="post" onsubmit="return validateForm()">
	<label for="employeeID">사원번호*</label>
	<input type="text" name="employeeID" readonly="readonly" value="${ emp.getEmployeeID() }"><br>
	<label for="firstName">이름</label>
	<input type="text" name="firstName" value="${ emp.getFirstName() }"><br>
	<label for="lastName">성*</label>
	<input type="text" name="lastName" value="${ emp.getLastName() }"><br>
	<label for="email">이메일*</label>
	<input type="text" name="email" value="${ emp.getEmail() }"><br>
	<label for="phone">핸드폰 번호</label>
	<input type="text" name ="phone" value="${ emp.getPhone() }"><br>
	<label for="hireDate">입사일*</label>
	<input type="date" name="hireDate" value="${ emp.getHireDate().substring(0,10) }"><br>
	
	<label for="jobId">직무*</label>
	 
	<select  name="jobId">
	 <!-- FK키// 직무는 선택하도록 for문 돌림 --> <!-- request.setAttribute("jobs")의 값을 가져옴 -->
	<c:forEach items="${ jobs }" var="job">
	<option value="${ job.getJobId() }"> <%-- <% if(jobs.getJobId().equals(vo.getJOB_ID())){ %>selected="selected"<% } %> --%>
	${ job.getJobTitle() } 
	</c:forEach>
	</select><br>
	
	<!-- radio for문 -->
	<label for="departmentId">부서번호</label>
	<c:forEach items="${depts }" var="dept">
	<input type="radio" name="departmentId" value="${ dept.getDepartmentId() }" 
	<c:if test="${dept.getDepartmentId() == emp.getDepartmentsId()}">checked="checked"</c:if>>
	${ dept.getDepartmentName()} 
	</c:forEach>
	
	<br>
	<label for="salary">연봉</label>
	<input type="text" name ="salary"  value="${ vo.getSalary() }"><br>
	<input type="submit" id="update" value="수정" ><br>
	<button type="button" onclick="empDelete()">삭제</button>
</form>
<%-- <script>
    function empDelete(){
    	location.href="EmpDeleteServ?employeeID=<%=vo.getEmployeeID()%>";
    }
    document.getElementsByName("jobId")[0].value = "<%=emp.getJOB_ID()%>";
    document.querySelector("[name=departmentId][value='<%=vo.getDepartmentsId()%>']").checked=true;

    </script> --%>

</body>
</html>