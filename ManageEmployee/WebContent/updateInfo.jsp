<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${loginUser.lev=='A' }">
	<jsp:include page="./adminHeader.jsp"/>
</c:if>
<c:if test="${loginUser.lev=='B' }">
	<jsp:include page="./userHeader.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<style>
	p{
		color:red;
	}
</style>
</head>
<body>
	<form action="login.do" method="get">
		<table border="1">
			<colgroup>
				<col width="300px">
				<col width="300px">
			</colgroup>
			<tr>
				<td colspan="2">
					<h3>사원 정보</h3>
					<p>${msg }</p>
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${loginUser.userId }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${loginUser.pwd }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${loginUser.name }</td>
			</tr>
			<tr>
				<th>권한</th>
				<td>${loginUser.lev }</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${loginUser.gender }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${loginUser.phone }</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="메인페이지로 이동">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>