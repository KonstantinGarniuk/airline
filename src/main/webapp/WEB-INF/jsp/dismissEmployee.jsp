<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="common/head.jsp"/>
        <c:url var="employeeStyleUrl" value="/css/employee.css" context="/"/>
        <c:url var="employeeJsUrl"    value="/js/employee.js"   context="/"/>

        <link rel="stylesheet" href="${employeeStyleUrl}">
        <script src="${employeeJsUrl}" defer></script>
    </head>
    <body>
        <jsp:include page="common/header.jsp"/>
        <h2>Вы действительно хотите уволить работника?</h2>
        <sf:form action="/employee/dismiss" method="POST">
            <input name="id" type="hidden" value="${employeeId}">
            <input type="submit"  value="Продолжить">
            <button type="button" onclick="cancelDismiss()">Отмена</button>
        </sf:form>
        
    </body>
</html>