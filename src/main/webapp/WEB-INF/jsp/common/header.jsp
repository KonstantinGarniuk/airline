<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<div class="header">
    <table class="top">
        <tr>
            <th>
                <c:url var="headerUrl" value="/images/header.jpg" context="/"/>
                <div onclick="showMainPage()"><img class="logo" src="${headerUrl}" alt="logo"/></div>
            </th>
            <th>
                <div class="greetings"          onclick="showMainPage()"    >Добро пожаловать в Gremlin Air Lines</div>
            </th>
        </tr>
    </table>
    
    <table class="menu">
        <tr>
            <th>
                <div class="menuItems" onclick="showSchedulePage()">Расписание рейсов</div>
            </th>
            <th>
                <div class="menuItems" onclick="showBookingPage()" >Бронирование билетов</div>
            </th>
            <sec:authorize access="hasRole('HR')">
                <th>
                    <div class="menuItems" onclick="showEmployeePage()">Работа с персоналом</div>
                </th>
            </sec:authorize>
            <th>
                <div class="menuItems" onclick="showAccountPage()" >Личный кабинет</div>
            </th>
        </tr>
    </table>
</div>