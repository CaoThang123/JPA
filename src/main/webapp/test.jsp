<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to the Test Page</h1>
	<form action="${pageContext.request.contextPath}/views" method="get">
		<input type="submit" value="Xem ListCategory">
	</form>
	
	<form action="${pageContext.request.contextPath}/videos" method="get">
		<input type="submit" value="Xem ListVideo">
	</form>
	<form action="${pageContext.request.contextPath}/users" method="get">
		<input type="submit" value="Xem ListUser">
	</form>
</body>
</html>