<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html lang="en">
    <head>
        <jsp:include page="common/head.jsp"/>
        <link rel="stylesheet" href="css/schedule.css">
        <script src="js/schedule.js" defer></script>
    </head>
    <body>
        <jsp:include page="common/header.jsp"/>
        <form action="/schedule">
            <table class="scheduleForm">
                <tr>
                    <th>
                        <label for="from">Расписание с: </label>
                        <input type="datetime-local" name="from">
                    </th>
                    <th>
                        <label for="to">до: </label>
                        <input type="datetime-local" id="to" name="to">
                    </th>
                    <th>
                        <input type="submit" value="Принять">
                    </th>
                </tr>
            </table>
        </form>
        <table class="schedule">
            <thead>
                <th>Departure airport</th>
                <th>Departure time</th>
                <th>Departure gate</th>
                <th>Arrival airport</th>
                <th>Arrival time</th>
                <th>Arrival gate</th>
                <th>Status</th>
            </thead>
            <c:forEach items="${flights}" var="flight">
                <tr class="flightInfo">
                    <th>
                        ${flight.departureAirport}
                    </th>
                    <th>
                        ${flight.departureTime}
                    </th>
                    <th>
                        <sec:authorize access="hasRole('DISPATCHER')">
                            <input class="gateInput" list="departureGates" value="${flight.departureGate}" onchange="setDepartureGate('${flight.id}', '${_csrf.token}')">
                            <datalist id="departureGates">
                                <c:forEach items="${flight.availableDepartureGates}" var="departureGate">
                                    <option value="${departureGate}">
                                </c:forEach>
                            </datalist> 
                        </sec:authorize>
                        <sec:authorize access="!hasRole('DISPATCHER')">
                            ${flight.departureGate}
                        </sec:authorize>
                    </th>
                    <th>
                        ${flight.arrivalAirport}
                    </th>
                    <th>
                        ${flight.arrivalTime}
                    </th>
                    <th>
                        <sec:authorize access="hasRole('DISPATCHER')">
                            <input input class="gateInput" list="arrivalGates" value="${flight.arrivalGate}" onchange="setArrivalGate('${flight.id}', '${_csrf.token}')">
                            <datalist id="arrivalGates">
                                <c:forEach items="${flight.availableArrivalGates}" var="arrivalGate">
                                    <option value="${arrivalGate}">
                                </c:forEach>
                            </datalist> 
                        </sec:authorize>
                        <sec:authorize access="!hasRole('DISPATCHER')">
                            ${flight.arrivalGate}
                        </sec:authorize>
                    </th>
                    <th>
                        ${flight.status}
                    </th>
                    <th>
                        ${flight.arrivalGate}
                    </th>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>