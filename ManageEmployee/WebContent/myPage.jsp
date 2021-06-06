<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  request.setCharacterEncoding("UTF-8"); %>
<%  response.setContentType("text/html; charset=UTF-8"); %>
<c:choose>
	<c:when test="${loginUser.lev=='A' || loginUser.lev=='B'}">
		<c:set var="access" value="ok"/>
		<c:set var="lev" value="${loginUser.lev }"/>
		<c:set var="gender" value="${loginUser.gender }"/>
	</c:when>
	<c:otherwise>
		<c:set var="access" value="no"/>
		<script>
			alert(`접근불가합니다!`);
			location.href="./index.jsp";
		</script>
	</c:otherwise>
</c:choose>
<c:if test="${lev=='A'}">
	<jsp:include page="./adminHeader.jsp"/>
</c:if>
<c:if test="${lev=='B'}">
	<jsp:include page="./userHeader.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
	table{
		text-align:center;
		margin-left:30%;
	}
	table tr th,
	table tr td{
		padding:10px;
	}
</style>
</head>
<body>
	<form action="myPage.do" method="post">
		<input type="hidden" name="levRe" value="${lev }">
		<input type="hidden" name="genRe" value="${gender }">
		<table border="1">
			<colgroup>
				<col width="300px">
				<col width="300px">
			</colgroup>
			<tr>
				<td colspan="2">
					마이페이지
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userId" value="${loginUser.userId }" readonly></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" value="${loginUser.pwd }"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${loginUser.name }"></td>
			</tr>
			<tr>
				<th>권한</th>
				<td>
					<select name="lev" id="levCk">
						<option value="A">운영자</option>
						<option value="B">일반회원</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<select name="gender" id="genHere">
						<option value="1">남자</option>
						<option value="2">여자</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone" value="${loginUser.phone }"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset"  value="취소" title="메인페이지로 이동합니다" onclick="location.href='login.do';">
				</td>
			</tr>
		</table>
	</form>
	<script src="./js/myPage.js"></script>
</body>
</html>