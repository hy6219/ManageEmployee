<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.js.dto.MyEmpDto" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  request.setCharacterEncoding("UTF-8"); %>
<%  response.setContentType("text/html;charset=UTF-8"); %>
<c:choose>
	<c:when test="${newEmp.lev=='A'}">
		<c:set var="lev" value="운영자"/>
	</c:when>
	<c:otherwise>
		<<c:set var="lev" value="일반회원"/>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${newEmp.gender=='1'}">
		<c:set var="gender" value="남자"/>
	</c:when>
	<c:otherwise>
		<<c:set var="gender" value="여자"/>
	</c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 등록 결과 페이지</title>
</head>
<body>
	<jsp:include page="../adminHeader.jsp"/>
	<form action="login.do" method="get">
		<table border="1">
			<colgroup>
				<col width="300px">
				<col width="300px">
			</colgroup>
			<thead>
				<tr>
					<td colspan="2">
						<h3>사원 정보</h3>
						<p id="msg">"${msg}"</p>
					</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>${newEmp.userId}</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>${newEmp.pwd }</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${newEmp.name }</td>
				</tr>
				<tr>
					<th>권한</th>
					<td>${lev}</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${gender }</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${newEmp.phone }</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="메인페이지로 이동">
					</td>
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>