<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="common/head.jsp"/>
        <c:url var="cancelTicketJsUrl"    value="/js/cancelTicket.js"   context="/"/>
        <script src="${cancelTicketJsUrl}" defer></script>
    </head>
    <body class="page">
        <jsp:include page="common/header.jsp"/>
        <h2>Вы действительно хотите отменить бронирование билета?</h2>
        <input id="ticketId" type="hidden" value="${ticketId}">
        <button onclick="confirm('${_csrf.token}')">Продолжить</button>
        <button onclick="cancel()">Отмена</button>
    </body>
</html>