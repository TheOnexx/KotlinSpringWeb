<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: (TheOne)
  Date: 08-Dec-18
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<form name='loginForm'
      action="<c:url value='/login' />" method='POST'>

    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit"
                                   value="submit" /></td>
        </tr>
    </table>

    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />

</form>
</body>
</html>
