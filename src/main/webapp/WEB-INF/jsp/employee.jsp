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
    <body onload="focusInput()">
        <jsp:include page="common/header.jsp"/>
        <table class="employeeList">
            <tr>
                <th><label>Фильтр: </label></th>
                <th><input id="userName"  oninput="filterEmployees('userName')" type="text" placeholder="User name" value="${filterInfo.userName}"></th>
                <th><input id="firstName" oninput="filterEmployees('firstName')" type="text" placeholder="First name" value="${filterInfo.firstName}"></th>
                <th><input id="lastName"  oninput="filterEmployees('lastName')" type="text" placeholder="Last name" value="${filterInfo.lastName}"></th>
            </tr>
            <tr>
                <th>
                    <button onclick="hire()">Принять на работу</button>
                </th>
            </tr>
        </table>
        <h3 id="employeeInfoHeader">Список работников:</h3>
        <table class="employeeList">
            <thead>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Должность</th>
                <th>Зарплата</th>
                <th>Акаунт</th>
                <th>Роль</th>
            </thead>
            <c:forEach items="${employeeList}" var="employee">
                <tr class="employeeInfo">
                    <th>${employee.firstName}</th>
                    <th>${employee.lastName}</th>
                    <th>${employee.job}</th>
                    <th>${employee.salary}</th>
                    <th>${employee.userName}</th>
                    <th>${employee.role}</th>
                    <th><button onclick="dismiss('${employee.id}')">Уволить</button></th>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>