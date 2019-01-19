<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="User Page template" pageEncoding="UTF-8"%>
<%@tag import="app.theone.entity.User" %>
<%@attribute name="users" required="true" type="java.util.List"%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Created On</th>
        <th>Last Login</th>
    </tr>
    <c:forEach items="${users}" var="users">
        <tr>
            <td>${users.userId}</td>
            <td><a href="${pageContext.request.contextPath}/user/${users.userId}">${users.userName}</a></td>
            <td>${users.password}</td>
            <td>${users.email}</td>
            <td>${users.createdOn}</td>
            <td>${users.lastLogin}</td>
            <td><a href="${pageContext.request.contextPath}/user/delete/${users.userId}">Delete</a> </td>
        </tr>
    </c:forEach>
</table>