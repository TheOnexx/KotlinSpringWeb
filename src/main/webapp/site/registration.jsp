<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: (TheOne)
  Date: 24-Nov-18
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
  <jsp:attribute name="header">
      <h2>Registration</h2>
  </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>

    <jsp:body>

        <form:form method="post" modelAttribute="user">
            <form:input path="userId" type="hidden"/>
            <table>
                <tr>
                    <td>
                        Name:
                    </td>
                    <td>
                        <form:input path="userName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Password:
                    </td>
                    <td>
                        <form:input path="password"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Email:
                    </td>
                    <td>
                        <form:input path="email"/>
                    </td>
                </tr>
                <input type="submit" value="Submit"/>
            </table>
        </form:form>
    </jsp:body>

</t:genericpage>