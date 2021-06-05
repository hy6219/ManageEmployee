<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("UTF-8"); %>
<%  response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<section>
		<article>
			<form action="" method="post">
				<jsp:include page="../userHeader.jsp"/>
				<jsp:include page="../commonBody/commonBody.jsp"/>
			</form>
		</article>
	</section>
</body>
</html>