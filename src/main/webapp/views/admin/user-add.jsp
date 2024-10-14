<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thêm User</title>
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <h2>Thêm User</h2>

    <!-- Hiển thị thông báo lỗi nếu có -->
    <c:if test="${not empty param.error}">
        <div style="color: red;">${param.error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/admin/user/insert" 
        method="post" enctype="multipart/form-data">

        <!-- Tên người dùng -->
        <label for="username">Tên người dùng:</label><br>
        <input type="text" id="username" name="username" required><br>

        <!-- Email -->
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br>

        <!-- Mật khẩu -->
        <label for="password">Mật khẩu:</label><br>
        <input type="password" id="password" name="password" required><br>

        <!-- Ảnh đại diện (URL) -->
        <label for="avatar">Đường dẫn ảnh đại diện:</label><br>
        <input type="text" id="avatar" name="avatar" 
            placeholder="Nhập đường dẫn ảnh nếu có"><br>

        <!-- Tải lên tệp ảnh -->
        <label for="avatarFile">Tải lên ảnh đại diện:</label><br>
        <input type="file" id="avatarFile" name="avatarFile" accept="image/*"><br>

        <!-- Trạng thái -->
        <label>Trạng thái:</label><br>
        <input type="radio" id="active" name="status" value="1" checked>
        <label for="active">Hoạt động</label><br>
        <input type="radio" id="inactive" name="status" value="0">
        <label for="inactive">Khóa</label><br>

        <input type="submit" value="Thêm User"><br>
    </form>

</body>
</html>
