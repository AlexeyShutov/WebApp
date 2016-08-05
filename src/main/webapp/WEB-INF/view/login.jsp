<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">
    <fieldSet>
        <legend>Please Login</legend>
        <c:if test="${param.error != null}">
            <div>
                Failed to login.
                <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                    Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                </c:if>
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div>You've been logged out</div>
        </c:if>
        <p>
            <label for="username">Username</label>
            <input type="text" id="username" name="username"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <p>
            <label for="remember-me">Remember Me?</label>
            <input type="checkbox" id="remember-me" name="remember-me"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <button type="submit" class="btn">Log In</button>
        </div>
    </fieldSet>
</form>
</body>
</html>
