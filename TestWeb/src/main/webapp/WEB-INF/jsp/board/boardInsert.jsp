<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Insert</title>
<script>
//document.getElementById('now_date').value = new Date(); // 오늘 날짜로 등록하도록 하고싶음..
console.log(new Date());
const parsedDate = Date.today().toString("MMMM dS, yyyy");
//document.getElementById('now_date').valueAsDate = new Date(); // 오늘 날짜로 등록하도록 하고싶음..
</script> 
<style>
form > label {
margin: 2px;
display : inline-block;
width: 15%;
color: white;
background-color: #04AA6D;
text-align:center;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/board/boardHeader.jsp"></jsp:include>
<form name="frm" action="boardInsert" id="boardform" method="post">
    <br>
    <label for="id">id</label>
	<input type="text" name="id" readonly="readonly"><br>
	<label for="title">title</label>
	<input type="text" name="title" value=""><br>
	<label for="lastName">content</label>
	<input type="text" name="content" value=""><br>
	<label for="email">writer</label>
	<input type="text" name="writer" value=""><br>
	<label for="rdt">rdt</label>
	<input type="date" id="now_date" name="rdt" value="2000-01-01" readonly="readonly" ><br>
	
	<!-- <label for="email">writer</label> 조회수는 자동생성되도록...--> 
	<input type="submit" id="insert" value="등록">
	
</form>

</body>
</html>