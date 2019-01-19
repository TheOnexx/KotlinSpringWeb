<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Admin panel</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
        End page
    </jsp:attribute>
    <jsp:body>
        <b>Users: </b>
        <t:userdata users="${users}"/>
    </jsp:body>
</t:genericpage>