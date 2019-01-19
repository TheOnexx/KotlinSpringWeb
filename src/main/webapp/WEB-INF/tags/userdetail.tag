<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="user" required="true" type="app.theone.entity.User" %>

<table>
    <tr>
        <td>Name:</td>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>Roles: </td>
        <s:forEach items="${user.roles}" var="roles">
            <td>${roles.role}</td>
        </s:forEach>
    </tr>
</table>