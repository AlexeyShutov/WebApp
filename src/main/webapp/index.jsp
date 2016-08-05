<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>DMS Application</title>
</head>
    Username: <b><sec:authentication property="principal.username"/></b>
    <br/><br/>
<c:url value="/admin" var="adminPage" />
    <a href="${adminPage}">Click to Enter Admin Area</a>
    <br/> <br/>
    <form action="logout" method="post">
        <input type="submit" value="Logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</body>
</html>
