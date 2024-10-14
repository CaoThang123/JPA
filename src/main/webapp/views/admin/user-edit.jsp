<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>

    <form action="<c:url value='/admin/user/update'></c:url>" 
        method="post" enctype="multipart/form-data">

        <!-- User ID (hidden) -->
        <input type="text" id="userid" name="userid" hidden="hidden" 
            value="${user.userId}"><br>

        <!-- User Name -->
        <label for="username">User Name:</label><br>
        <input type="text" id="username" name="username" 
            value="${user.userName}" required><br>

        <!-- Email -->
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" 
            value="${user.email}" required><br>

        <!-- Current Avatar -->
        <label for="avatar">Current Avatar:</label><br>
        <c:if test="${user.avatar.substring(0, 5) == 'https'}">
            <c:url value="${user.avatar}" var="imgUrl"></c:url>
        </c:if>
        <c:if test="${user.avatar.substring(0, 5) != 'https'}">
            <c:url value="/image?fname=${user.avatar}" var="imgUrl"></c:url>
        </c:if>
        <img id="avatarPreview" height="150" width="200" src="${imgUrl}" /><br>

        <!-- Upload New Avatar -->
        <label for="avatarFile">Upload New Avatar:</label><br>
        <input type="file" onchange="chooseFile(this)" id="avatarFile" 
            name="avatarFile" accept="image/*"><br>

        <!-- Status -->
        <p>Status:</p>
        <input type="radio" id="active" name="status" value="1" 
            ${user.status == 1 ? 'checked' : ''}>
        <label for="active">Active</label><br>

        <input type="radio" id="inactive" name="status" value="0" 
            ${user.status != 1 ? 'checked' : ''}>
        <label for="inactive">Inactive</label><br>

        <input type="submit" value="Update">
    </form>

    <script>
        // Preview uploaded image
        function chooseFile(input) {
            if (input.files && input.files[0]) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    document.getElementById('avatarPreview').src = e.target.result;
                };
                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
</body>
</html>
