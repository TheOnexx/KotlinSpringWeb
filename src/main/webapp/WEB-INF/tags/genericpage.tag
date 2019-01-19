<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<body>
<div id="pageheader">
    <div>
        <h1>Template Logo</h1>
    </div>
    <jsp:invoke fragment="header"/>
</div>
<div id="body">
    <jsp:doBody/>
</div>
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
</div>
</body>
</html>