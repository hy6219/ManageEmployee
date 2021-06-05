<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록</title>
<link rel="stylesheet" href="./css/reg.css">
</head>
<body>
	<%@ include file="../adminHeader.jsp" %>
	<div class="section">
		<form action="custom.do" method="post" id="frm">
		<label>*표시는 필수 입력항목입니다!</label>
		<table border="1">
			<thead>
				<tr>
					<td colspan="2">
					사원등록
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userId" size="10" id="userId">*</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" size="10" id="pwd">*</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" size="24"></td>
				</tr>
				<tr>
					<th>권한</th>
					<td>
						<select name="lev">
							<option value="A">운영자</option>
							<option value="B" selected>일반회원</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<select name="gender">
							<option value="1" selected>남자</option>
							<option value="2">여자</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone" size="30" placeholder="010-1234-5678"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록" onclick="return validate();">
						<input type="reset" value="취소" title="입력하신 모든 내용이 지워집니다">
						<input type="button" value="메인 페이지로 이동" onclick="location.href='./login.do';">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	<script src="./js/register.js"></script>
</body>
</html>