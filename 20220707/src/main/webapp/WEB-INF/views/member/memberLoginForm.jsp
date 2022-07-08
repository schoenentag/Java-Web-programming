<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
  width: 20%; 
  border: 1px solid #ddd; 
  font-size: 16px; 
}
</style>
</head>
<body>
	<div align="center"> <!-- align -->
		<div> <!-- 로그인 -->
			<h1>로 그 인</h1>
		<div> <form id="frm" action="memberLogin.do" method="post"> <!-- from -->
		<table border="1"> 
			<tr>
				<th width="150">아 이 디</th>
				<td width="200"><input type="text" id="memberID"
					name="memberId" required="required" placeholder="Enter Your ID...">
					<!-- required 필수입력 --></td>
			</tr>
			<tr>
				<th width="150">패스워드</th>
				<td width="200"><input type="password" id="memberPassWord"
					name="memberPassWord" required="required"
					placeholder="Enter Your Password..."></td>
			</tr>
		</table>
	</div><br> <!-- from -->
	<div> <!-- 버ㅡ튼 -->
		<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp; <input
			type="reset" value="취 소">&nbsp;&nbsp;&nbsp; <input
			type="button" value="홈 가기" onclick="location.href='main.do'">
	</div><!-- 버ㅡ튼 -->
	</form>
	</div> <!-- 로그인 -->
	</div> <!-- align -->
</body>
</html>