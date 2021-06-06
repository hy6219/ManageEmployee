<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="./css/header.css">
</head>
<body>
	<section>
		<article>
			<form action="login.do" id="frm" method="post">
				<table id="header" border="1">
					<tr>
						<td></td>
						<td></td>
						<td onclick="location.href='login.do';">로그인</td>
						<td id="access1">사원등록<p>(관리자로 로그인 후 사용가능)</p></td>
						<td id="access2">마이페이지<p>(로그인 후 사용가능)</p></td>
					</tr>
				</table>
				<table id="loginForm" border="1">
					<tr>
						<td colspan="2" >로그인</td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId" size="20"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pwd" size="20"></td>
					</tr>
					<tr>
						<th>레벨</th>
						<td>
							<select name="level">
								<option value="B" selected>일반회원</option>
								<option value="A">관리자</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" value="로그인" id="check">&nbsp;
						<input type="reset"  title="입력하신 내용 모두 지워집니다" value="취소">
						</td>
					</tr>
			    </table>
			</form>
		</article>
	</section>
	<script src="./js/main.js"></script>
</body>
</html>