<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = "${msg}";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
</head>
<body>
<section>
		<article>
			<form action="" method="post">
				<jsp:include page="../adminHeader.jsp"/>
				<jsp:include page="../commonBody/commonBody.jsp"/>
				<label>${msg}</label>
			</form>
		</article>
	</section>
</body>
</html>