<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html lang="en">
    <head>
        <jsp:include page="common/head.jsp"/>
    </head>
    <body class="page">
        <jsp:include page="common/header.jsp"/>
        <h1>ACCOUNT PAGE!</h1>
        <sec:authorize access="!isAuthenticated()">
            <h2><a href="/login">Login</a></h2> <br>
            <h2><a href="/registration">Registration</a></h2>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <h2><a href="<c:url value="/logout" />">Logout</a></h2>
        </sec:authorize>
    </body>
</html>