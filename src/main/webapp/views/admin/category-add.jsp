<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Thêm Danh Mục</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<!-- Thêm CSS nếu có -->
</head>
<body>

	<h2>Thêm Danh Mục</h2>

	<!-- Hiển thị thông báo lỗi nếu có -->
	<c:if test="${not empty param.error}">
		<div style="color: red;">${param.error}</div>
	</c:if>

	<form action="${pageContext.request.contextPath}/admin/category/insert"
		method="post" enctype="multipart/form-data">

		<label for="categoryname">Tên danh mục:</label><br> <input
			type="text" id="categoryname" name="categoryname" required><br>

		<label for="images">Đường dẫn ảnh:</label><br> <input type="text"
			id="images" name="images" placeholder="Nhập đường dẫn ảnh nếu có"><br>

		<label for="images1">Tải lên tệp:</label><br> <input type="file"
			id="images1" name="images1" accept="image/*"><br> <label>Trạng
			thái:</label><br> <input type="radio" id="ston" name="status" value="1"
			checked> <label for="ston">Hoạt động</label><br> <input
			type="radio" id="stoff" name="status" value="0"> <label
			for="stoff">Khóa</label><br> <input type="submit" value="Thêm"><br>
	</form>

</body>
</html>
