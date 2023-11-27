<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="common/head.jsp"/>
        <c:url var="accountStyleUrl" value="/css/account.css" context="/"/>
        <c:url var="accountJsUrl"    value="/js/account.js"   context="/"/>

        <link rel="stylesheet" href="${accountStyleUrl}">
        <script src="${accountJsUrl}" defer></script>
    </head>
    <body class="page">
        <jsp:include page="common/header.jsp"/>
        <sec:authorize access="!isAuthenticated()">
            <h2>Здравствуйте!</h2>
            <button onclick="login()">Войти</button> <br>
            <button onclick="registarate()">Зарегистрироваться</button>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <h2 class="userInfo">${accountInfo.userName}</h2>
            <c:if test="${accountInfo.discount > 0}">
                <p class="userInfo">Постоянная кидка составляет ${accountInfo.discount}%</p>
            </c:if>
            <p class="userInfo">Личные данные</p>
            <sf:form action="/account" method="POST" modelAttribute="personInfo">
                <table id="personInfo">
                    <thead>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>ДР</th>
                        <th>ИД</th>
                    </thead>
                
                    <tr>
                        <th>
                            <div class="personInfoDisplay">${accountInfo.firstName}</div>
                            <div class="personInfoUpdate"><sf:input path="firstName" type="text" value="${accountInfo.firstName}"/></div>
                        </th>
                        <th>
                            <div class="personInfoDisplay">${accountInfo.lastName}</div>
                            <div class="personInfoUpdate"><sf:input path="lastName" type="text" value="${accountInfo.lastName}"/></div>
                        </th>
                        <th>
                            <fmt:parseDate value="${accountInfo.dob}" pattern="yyyy-MM-dd" var="parsedDate" type="date"/>
                            <div class="personInfoDisplay"><fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy"/></div>
                            <div class="personInfoUpdate"><sf:input path="dob" type="date" value="${accountInfo.dob}"/></div>
                        </th>
                        <th>
                            <div class="personInfoDisplay">${accountInfo.pid}</div>
                            <div class="personInfoUpdate"><sf:input path="pid" type="text" value="${accountInfo.pid}"/></div>
                        </th>
                        <th>
                            <div class="personInfoDisplay"><button type="button" onclick="updatePersonInfo()">Изменить</button></div>
                            <div class="personInfoUpdate"><input type="submit" value="Принять"/></div>
                        </th>
                    </tr>
                </table>
            </sf:form>
            <p class="userInfo">История полётов</p>
            <table class="fligthList" id="flightsHistory">
                <thead>
                    <th>Откуда</th>
                    <th>Время вылета</th>
                    <th>Куда</th>
                    <th>Время прилёта</th>
                    <th>Багаж</th>
                    <th>Цена</th>
                    <th>Состояние</th>
                </thead>
                <c:forEach items="${flightsHistory}" var="flight">
                    <tr class="flightInfo">
                        <th>${flight.departureAirport}</th>
                        <th>${flight.departureTIme}</th>
                        <th>${flight.destinationAirport}</th>
                        <th>${flight.arrivalTime}</th>
                        <th>${flight.luggage}</th>
                        <th>${flight.price}</th>
                        <th>${flight.status}</th>
                        <th>
                            <c:if test="${(flight.status == 'Booked') || (flight.status == 'Paid')}">
                                <button type="button" onclick="canselTicket('${flight.id}')">Отменить</button>
                            </c:if>
                        </th>
                    </tr>
                </c:forEach>
            </table>
            <button onclick="logout()">Выйти</button>
        </sec:authorize>
    </body>
</html>