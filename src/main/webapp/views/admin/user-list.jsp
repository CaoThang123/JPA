<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<a href="<c:url value='/views/admin/user-add.jsp'></c:url>">Add User</a>
<table border="1">
    <tr>
        <th>STT</th>
        <th>Avatar</th>
        <th>User Name</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listUsers}" var="user" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <c:if test="${user.avatar.substring(0, 5) == 'https'}">
                <c:url value="${user.avatar}" var="imgUrl"></c:url>
            </c:if>
            <c:if test="${user.avatar.substring(0, 5) != 'https'}">
                <c:url value="/image?fname=${user.avatar}" var="imgUrl"></c:url>
            </c:if>
            <td><img height="150" width="200" src="${imgUrl}" /></td>
            <td>${user.userName}</td>
            <td>
                <c:if test="${user.status == 1}">
                    <span>Active</span>
                </c:if>
                <c:if test="${user.status != 1}">
                    <span>Inactive</span>
                </c:if>
            </td>
            <td>
                <a href="<c:url value='/admin/user/edit?id=${user.userId}'/>">Edit</a>
                | 
                <a href="<c:url value='/admin/user/delete?id=${user.userId}'/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
