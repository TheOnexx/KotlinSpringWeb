<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:genericpage>
    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>

        <p>${sysMsg}</p>
        <br>
        <a href="${pageContext.request.contextPath}/user/add">Registration</a>
        <br>
        <p>---------------------ADMIN ZONE-------------</p>
        <a href="${pageContext.request.contextPath}/admin">Admin Panel</a>
    </jsp:body>

</t:genericpage>