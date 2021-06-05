<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/header.css">
</head>
<body>
	<input type="hidden" name="lev" value="${loginUser.lev}">
	<table id="header" border="1">
		<tr>
			<td id="name">${loginUser.name}님 반갑습니다.</td>
			<td id="lev">레벨 : ${loginUser.lev}</td>
			<td onclick="location.href='./logout.do';">로그아웃</td>
			<td id="regEmp">사원등록<p>(관리자로 로그인 후 사용가능)</p></td>
			<td id="myPage" onclick="location.href='./myPage.do';">마이페이지</td>
		</tr>
   </table>
   <script src="./js/action.js"></script>
</body>
</html>